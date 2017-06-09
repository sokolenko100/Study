document.addEventListener("DOMContentLoaded", init());
var ws,
    textArea,
    message,
    login,
    select,
    url,
    xmlhttp;
function init()
{
    login = loginIn();
	url = "http://localhost:8080/RestServer_v_3.0/massage/";
    textArea = document.getElementsByClassName("center_textarea")[0];
    message = document.getElementsByClassName("message")[0];
    document.getElementById("label").innerText = login;
    xmlhttp = new XMLHttpRequest();
    message.onkeyup = function(e)
    {
        if(e.keyCode ==13)
        {
        	getMassege();
        }
    };
    var timerId = setInterval(function() {
    	getMassege();
    	}, 4000);
}

function getMassege()
{
	if(message.value!="")
	{
		var result = login + ": " + message.value+"\n";
	    xmlhttp.open('GET',url + result,true);
	    xmlhttp.send(null);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4)
			{
		      if ( xmlhttp.status == 200) 
		      {
		    	  textArea.value = xmlhttp.responseText;
		      }           
		     }
		};
		message.value ="";
	}
}
function loginIn()
{
    var login = "";

    login = prompt("Enter your login");
    console.log("login = " + login);

    return login;
}
