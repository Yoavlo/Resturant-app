
<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>-->

	<!DOCTYPE html>
	<html lang="en">
	<head>
	  <title>Bootstrap Example</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <script
	  src="https://code.jquery.com/jquery-2.2.4.min.js"
	  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
	  crossorigin="anonymous"></script>
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

	</style>

	   
	  <script>  
	 
			 $(document).ready(function() {  
			  var count=0
		
			  $.get("http://localhost:8080/yaakovRestaurant/rs/HomePage", function(response){ //response is a string that contains the name of the categorys, like lunch. 
			  valuesOfCategorys= response.split(" ");	// valuesOfCategorys= ["breakfast", "lunch", "wine"];
			 })
			 .success(function() {
				setValuesInButtons();	
				replaceHtmlByButtonClick();			 
			   })
			  .fail(function() {
				alert( "error" );
			  });
				  
				function setValuesInButtons()
				{
					for(i=0; i<valuesOfCategorys.length/3; i++)
						{
						$(".container-fluid").append('<div class="row margin-bot">');
						for(j=0; j<3; j++)
						    {
							if(valuesOfCategorys[count]!=null && valuesOfCategorys[count]!= "")
						    	{
								$(".container-fluid").append('<div class="col-sm-4 text-center" style="background-color:lavender;"><button name="singlebutton" class="btn btn-primary">'+ valuesOfCategorys[count]+'</button></div>');
								count++;
								}
							}
						$(".container-fluid").append("</div>");
						}
				}

				function replaceHtmlByButtonClick()
				{
					var buttons = document.getElementsByClassName('btn btn-primary');
					for (var i=0 ; i < buttons.length ; i++)
					{
					  (function(index)
					  {
						buttons[index].onclick = function()
						{
						 localStorage.setItem("variable",valuesOfCategorys[index]);
						 localStorage.setItem("valuesOfCategorys", valuesOfCategorys);
						 window.location.replace("Order.jsp");
						};
				      })(i)
				  }
				}

			 });  
			 

			 
			

	  </script>  
	</head>
	<body>
		<div class="container-fluid">
		  <h1>Jaakov Resturant</h1>
		</div>

		<div class="col-sm-12 text-center bottom-of-page">
			<button name="singlebutton" class="btn btn-success">options</button>
		</div>


	</body>
	</html>


