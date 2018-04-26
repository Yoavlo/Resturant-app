
<!--
<html>
<head>

<link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
 
<div id="container">
    <div id="menu">
        <p class="welcome">Welcome, guest table 18 <b></b></p>
    </div>
     
    <div id="chatbox">
	</div>
     
    <form name="message" action="">
        <input name="usermsg" type="text" id="usermsg" size="63" />
        <input name="submitmsg" type="submit"  id="submitmsg" value="Send" />
    </form>
</div>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
<script type="text/javascript">
// jQuery Document
$(document).ready(function(){
 
});
</script>
</body>
</html>-->


<!--origin requests are only supported for protocol schemes: http, data, chrome, chrome-extension, https. -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<!--https://code.tutsplus.com/tutorials/how-to-create-a-simple-web-based-chat-application--net-5931 -->
<link type="text/css" rel="stylesheet" href="../css/style.css" />

</head>
<?php
session_start();
?>
	<div id="container">
		<div id="menu">
			<p class="welcome">Welcome, Guest table 7</p>
		</div>
		
		<div id="chatbox"></div>
					
		

		<form name="message" action="">
			<input name="usermsg" type="text" id="usermsg" size="63" />
			<input name="submitmsg" type="submit"  id="submitmsg" value="Send" />
		</form>
	</div>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
<script type="text/javascript">
// jQuery Document

$(document).ready(function(){
	
	//User submits the form
	$("#submitmsg").click(function(){	

		var clientmsg = $("#usermsg").val(); //grabs the user message
		$.post("post.php", {text: clientmsg}); //send a post request to post.php with the user message	

		$("#usermsg").attr("value", "");//clear the user message to nothing
           
		return false;
	});
 
});



	
	//Load the file containing the chat log
	function loadLog(){		

		$.ajax({
			url: "log.html",
			cache: false,
			success: function(html){		
				$("#chatbox").html(html); //Insert chat log into the #chatbox div				
		  	},
		});
	}
	
	
	//Load the file containing the chat log
	function loadLog(){		
		var oldscrollHeight = $("#chatbox").attr("scrollHeight") - 20; //Scroll height before the request
		$.ajax({
			url: "log.html",
			cache: false,
			success: function(html){		
				$("#chatbox").html(html); //Insert chat log into the #chatbox div	
				
				//Auto-scroll			
				var newscrollHeight = $("#chatbox").attr("scrollHeight") - 20; //Scroll height after the request
				if(newscrollHeight > oldscrollHeight){
					$("#chatbox").animate({ scrollTop: newscrollHeight }, 'normal'); //Autoscroll to bottom of div
					//setInterval (loadLog, 2500);
				}				
		  	},
		});
	}
</script>
</body>
</html>