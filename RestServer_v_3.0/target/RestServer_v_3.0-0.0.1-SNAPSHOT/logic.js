document.addEventListener("DOMContentLoaded", init());
var ws,
    textArea,
    message,
    login,
    select,
     xhr;
function init()
{
    login = loginIn();

    textArea = document.getElementsByClassName("center_textarea")[0];
    message = document.getElementsByClassName("message")[0];
    document.getElementById("label").innerText = login;
    xhr = new XMLHttpRequest();
    message.onkeyup = function(e)
    {
        if(e.keyCode ==13)
        {
        	getMassege();
        }
    };
}
var invocation = new XMLHttpRequest();
var url = "http://localhost:8080/RestServer_v_3.0/massage/";
   
function getMassege() {
  if(invocation) {    
    invocation.open('GET', url + message.value, true);
    invocation.setRequestHeader('X-PINGOTHER', 'pingpong');
    invocation.setRequestHeader('Content-Type', 'text/plain');
    invocation.onreadystatechange = function () {
        if(invocation.readyState === XMLHttpRequest.DONE && invocation.status === 200) {
        	   textArea.value = invocation.responseText;
        };
    };
    invocation.send(); 
 
  }
}
function getMasseges()
{
    	xhr.open('GET', 'http://localhost:3000/RestServer_v_3.0/massage/'+ message.value, true);
    	xhr.send();
    	if (xhr.status != 200) {
    	} else {
    		textArea.value = xhr.responseText;
    	}

    message.value ="";
}
function loginIn()
{
    var login = "";

    login = prompt("Enter your login");
    console.log("login = " + login);

    return login;
}
