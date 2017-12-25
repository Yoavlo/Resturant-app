<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   < <script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script> 
	
<script>
//category: breakfast:
//[{"idDish":1,"available":true,"price":20.0,"info":"This French omelete recipe is a classic","idCategory":1,"name":"omelet"},
//{"idDish":2,"available":true,"price":30.0,"info":"This simple and delicious pancake is perfect for weekend breakfast\u0027s","idCategory":1,"name":"pancake"},
//{"idDish":3,"available":false,"price":15.0,"info":"Porridge is a good staple breakfast; it’s cheap, it’s filling and it’s nutritious","idCategory":1,"name":"banana \u0026 cinnamon porridge"}]
	  
	$(document).ready(function() 
		{
		var jsonOfOrder={ "orderId": null,          
			"comment": null,
			"timeOfOrder":null,
			"tableNumber":18,
			"order":[]}	;
		//var jsonOFDishAmount;
		var dishAmount=[];
	
		//	"order":[{"idDish": 0, "orderAmount": 0}, {"idDish": 0, "orderAmount":0}]};
		
		var valuesOfCategorys =localStorage.getItem("valuesOfCategorys").split(",");
	//	alert(valuesOfCategorys[0]);
		//alert(localStorage.getItem("variable"));
        if(localStorage.getItem("variable"))
		{
		  for(i=0;i<valuesOfCategorys.length; i++)
		    {
			   if(localStorage.getItem("variable")==valuesOfCategorys[i])
			   {
				getAllDishsInCategory(i+1);
				
		
				}
		    }
		    localStorage.removeItem("variable");
		}
		
		function getAllDishsInCategory(idCategory)
		{
		     var allDishes
			 $.get("http://localhost:8080/yaakovRestaurant/rs/dish?idCategory="+idCategory, function(response){ //response is a json
		    allDishes=response;
	    	 })
		    .success(function() {	
			
			  	buildTable(allDishes);
			//	updateJson(allDishes);
				infoButtons(allDishes);
				addDishButtons(allDishes);
				removeDishButtons(allDishes);
			  })
		   .fail(function() {
			alert( "error" );
		    })
		    .done(function() {
			});
		
		}
		function buildTable(allDishes)
		{
			for(i=0 ; i< allDishes.length; i++)
			  {
				dish= allDishes[i];
				name= dish["name"];
				price= dish["price"];
				info= dish["info"];
				$("tbody").append('<tr scope=row class= jsonOfDishIndex'+i+'>');
				$(".jsonOfDishIndex"+i).append('<td class=nameOfDishIndex'+i+'>'+ name+'    <img id="idRemoveButton'+i+'" class="remove.png" height=20 width=20 alt="info"></td>');
			    $(".jsonOfDishIndex"+i).append('<td class=infoOfDishIndex'+i+'>'+ info+'</td>');
				$(".jsonOfDishIndex"+i).append('<td>'+ price+'$ </td>');
				$(".jsonOfDishIndex"+i).append('<td><img class="infoButtton" src="info.png" height="20" width="20" alt="info"> <img class="addButtonToOrder" src="add.png" height="20" width="20" alt="add"></td>');
				$("tbody").append('</tr>');
				$(".infoOfDishIndex"+i).toggle();
				$("#idRemoveButton"+i).hide();
				
				dishAmount[i]=0;
				
				//jsonOfOrder["order"]+= {"idDish": dish["idDish"],"orderAmount":0 }
		//		jsonOFDishAmount= {"idDish": dish["idDish"],"orderAmount":0 };
	//			alert("jsonOFDishAmount:"+jsonOFDishAmount["idDish"]);
		    	}
			//bla=jsonOfOrder["order"]
			//$("p").append(bla[2]);
			/*
			for(i=0; i<allDishes.length; i++)
			{
			dish=jsonOfOrder["order"]
			}*/
		//	jsonDish=jsonOfOrder["order"];
			
		//	$("p").append(JSON.stringify(jsonOfOrder))	;
			
		}
		function updateJson()
		{
		}
		
		
		function infoButtons(allDishes)
			{
			var allInfoButtons= document.getElementsByClassName('infoButtton'); 	
				for (var i=0 ; i < allInfoButtons.length ; i++){
				  (function(index){
					allInfoButtons[index].onclick = function()
					{
					dish= allDishes[index];
					info= dish["info"];
					//alert(info);
					$(".infoOfDishIndex"+index).toggle(1500,"swing");
				};
			  })(i)
			  }
			}
			
			
		function addDishButtons(allDishes)
			{
			//{ "orderId: 1,          //auto genreted in Mysql
			//"comment": "omlete without tomato",
			//"timeOfOrder": 20:00 09/12/2017,
			//"tableNumber:18,
			//[{"dishId": 1, orderAmount: 3}, {"dishId": 2, orderAmount:0"}]}
			var addDishButtons= document.getElementsByClassName('addButtonToOrder'); 	
				for (var i=0 ; i < addDishButtons.length ; i++){
				  (function(index){
					addDishButtons[index].onclick = function()
					{
					dishAmount[index]=dishAmount[index]+1;
				//	$(".nameOfDishIndex"+index).append("<span>+"+dishAmount[index]+"</span>");
				//	alert(dishAmount[index]);
					alert("index: "+index)
				   if(dishAmount[index]>0)
				   {
				   $(".nameOfDishIndex"+index).html(allDishes[index].name+'<span>+'+dishAmount[index]+'</span>');
				   $("#idRemoveButton"+index).show();
				   }
				   else
				   {
				  $("#idRemoveButton"+index).hide();
				   }
				 //  removeDishButtons(allDishes);
					
				};
			  })(i)
			  }
			}
		
		function removeDishButtons(allDishes)
		{
					var removeDishButtons= document.getElementsByClassName('removeButton'); 
					alert("removeDishButtons in function" )
				for (var i=0 ; i < removeDishButtons.length ; i++){
				  (function(index){
					removeDishButtons[index].onclick = function()
					{
						alert("removeDishButtons in on click function. index: "+index)
					dishAmount[index]--;
				//	$(".nameOfDishIndex"+index).append("<span>+"+dishAmount[index]+"</span>");
				   if(dishAmount[index]>0)
				   {
				   $(".nameOfDishIndex"+index).html(allDishes[index].name+'<span>+'+dishAmount[index]+'</span>');
				    $(".removeButton "+index).show();
				   }
				   else
				   {
				   	$(".nameOfDishIndex"+index).html(allDishes[index].name+"<span>+"+dishAmount[index]+"</span>");
					 $(".removeButton "+index).hide();
				   }
				};
			  })(i)
			  }
		}
	  
  });

</script>

  <style>
.margin-bot
{
margin-bottom: 2%;
}

.bottom-of-page
{
position:absolute;
bottom:10%;
}

span{
color:deepSkyBlue;
}
  </style>
</head>

<body>
<h1 style="color:blue"> order</h1>
<div class="container"> 
	<table class="table table-striped table-bordered table-hover ">
	
		<tbody>
<!--
		<tr>
			<td><img src="info.png" height="20" width="20" alt="info"> <img src="add.png" height="20" width="20" alt="add"></td>
			<td> 20$ </td>
			<td>info0  </td>
			<td>pancake  </td>
		</tr>
		<tr>
			<td><img src="info.png" height="20" width="20" alt="info"> <img src="add.png" height="20" width="20" alt="add"></td>
			<td> 10$ </td>
				<td>info1  </td>
			<td>pancake  </td>
		</tr>
	    <tr>
			<td><img src="info.png" height="20" width="20" alt="info"> <img src="add.png" height="20" width="20" alt="add"></td>
			<td> 30$ </td>
			<td>pancake  </td>
			<td>info2  </td>
		
		</tr>
		-->
		</tbody>
	</table>
	
<button class="btn btn-success bottom-of-page margin-bot">Order</button>
</div>
<p></p>
</body>

</html>