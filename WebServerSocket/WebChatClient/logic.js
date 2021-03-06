document.addEventListener("DOMContentLoaded", init());
var ws,
    textArea,
    message,
    login,
    select,
    rooms = [],
    allRooms = "allRooms",
    newRooms = "newRoom",
    sMessage = "sendMessage";
function init()
{
    login = loginIn();

    textArea = document.getElementsByClassName("center_textarea")[0];
    select = document.getElementsByClassName("select")[0];
    message = document.getElementsByClassName("message")[0];
    document.getElementById("label").innerText = login;

    message.onkeyup = function(e)
    {
        if(e.keyCode ==13)
        {
            send();
        }
    };
    setConnection();
}
function ChatRoom(roomsName,story)
{
    this.roomsName = roomsName;
    this.story = story;
}
function CreateOption(roomsName) {
    var option = document.createElement("option");

    option.setAttribute("selected","selected");
    option.innerText = roomsName;

    option.addEventListener("click", function (e) {
        var name = this.value;

        rooms.forEach(function (item, index, arr) {

            if(item.roomsName === name )
            {
                textArea.value = item.story;
                console.log("room.story = " + item.story);
            }
        });
    });
    select.appendChild(option);
    option.focus();
}
var countDefaultRoomsName = 0;
function CreateNewRoom() {

    var roomsName = prompt("Enter rooms name");
    if(roomsName==="")
    {
        roomsName ="default" + countDefaultRoomsName;
        countDefaultRoomsName++;
    }

    var room = new ChatRoom(roomsName,"");
    var tempJson = JSON.stringify(room);
    console.log("tempJson: " + tempJson);
    rooms.push(room);

    sendMessage("newRoom:" + roomsName);
    CreateOption(roomsName);

    console.log("roomsName: " + roomsName);
}
function send()
{
    if(rooms.length!=0)
    {
        var txt = select.options[select.selectedIndex].innerText;
        sendMessage("sendMessage:" + txt + ":" + message.value);
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
function solveCommand(args)
{
    var arrayCommand = args.split(":",1);
    var tempObj =  args.substring(arrayCommand[0].length+1);
    switch (arrayCommand[0])
    {
        case allRooms :
            if(tempObj ==="]")
            {
                return;
            }
            var room = JSON.parse(tempObj);
            room.forEach(function (item, index, arr) {
                rooms.push(new ChatRoom(item.roomsName,item.story));
                CreateOption(item.roomsName);
                console.log(rooms);
            });
            break;

        case newRooms :
            var newRoom = JSON.parse(tempObj);
            rooms.push(new ChatRoom(newRoom.roomsName,newRoom.story));
            CreateOption(newRoom.roomsName);
            console.log(newRoom);
            break;

        case sMessage :{
            var txt = select.options[select.selectedIndex].innerText;
            var room = JSON.parse(tempObj);
            console.log("room = " + room);
            console.log(room);
            rooms.forEach(function (item, index, arr) {
                console.log("room = " + item);
                if(item.roomsName === room.roomsName )
                {
                    console.log("room.story = " + room.story);
                    item.story = room.story;
                    if(txt === room.roomsName )
                    {
                        textArea.value = room.story;
                    }
                }
            });
        } break;
    }
}
function setConnection()
{
    ws = new WebSocket("ws://localhost:4567");

    ws.onopen = function(){
        console.log("login:"+login);
        sendMessage("setLogin:"+login);
    };

    ws.onmessage = function(message){
        console.log("login = " + message.data);
        solveCommand(message.data);
    };

    ws.onclose= function(){
        ws.close();
        console.log("socket closed");
    }
}
function sendMessage(message)
{
    ws.send("ChatModule:" + message);
}