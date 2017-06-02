document.addEventListener("DOMContentLoaded", init());
var ws,
    textArea,
    message,
    login;
function init()
{

    login = loginIn();
    setConnection();
    textArea = document.getElementsByClassName("center_textarea")[0];
    message = document.getElementsByClassName("message")[0];
    document.getElementById("label").innerText = login;
    message.onkeyup = function(e)
    {
        if(e.keyCode ==13)
        {
            send();
        }
    }
}
function send()
{
    sendMessage(message.value);
    message.value ="";
}
function loginIn()
{
    var login = "";
    login = prompt("Enter your login");
    console.log("login = " + login);
    return login;
}
function setConnection()
{
    ws = new WebSocket("ws://localhost:4567");
    ws.onopen = function(){
        console.log("login:"+login);
        sendMessage("login:"+login);
    };

    ws.onmessage = function(message){
        console.log("login = " + message.data);
        textArea.value = message.data;
    };

    ws.onclose= function(){
        ws.close();
        console.log("socket closed");
    }
}

function sendMessage(message)
{
    ws.send("ChatModule:send:" + message);
}