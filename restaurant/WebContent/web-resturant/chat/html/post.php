<?
session_start();
    $text = $_POST['text']; //Grabs the post data text of the message we send using jQuery, and stores it in  $text variable
	
    $fp = fopen("log.html", 'a'); //Opens the log.html as write only. If the file does not exit, the program will create one
	
	$message = "wrong answer";
	echo "<script type='text/javascript'>alert('$message');</script>";
	
	//fwrite() function writes in the file. 
    fwrite($fp, "<div class='msgln'>(".date("g:i A").") <b> Guest table 7</b>: ".stripslashes(htmlspecialchars($text))."<br></div>");
	
    fclose($fp); //close the log.html file
?>


<?/*
session_start();
if(isset($_SESSION['name'])){
    $text = $_POST['text'];
     
    $fp = fopen("log.html", 'a');
    fwrite($fp, "<div class='msgln'>(".date("g:i A").") <b>".$_SESSION['name']."</b>: ".stripslashes(htmlspecialchars($text))."<br></div>");
    fclose($fp);
}
*/
?>
