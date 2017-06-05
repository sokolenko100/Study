document.addEventListener("DOMContentLoaded", init());
var ws,
    canvas,
    ctx,
    login,
    select,
    rooms = [],
    currentX,
    currentY,
    allRooms = "allRooms",
    newRooms = "newRoom",
    sMessage = "draw";
function init()
{
    login = loginIn();

    textArea = document.getElementsByClassName("center_textarea")[0];
    canvas   = document.getElementById("canvas");
    ctx      = canvas.getContext("2d");
    select   = document.getElementsByClassName("select")[0];
    document.getElementById("label").innerText = login;

    canvas.addEventListener('mousedown',function(e)
    {
        setPosition('down',e);
    });
    canvas.addEventListener('mouseup',function(e)
    {
        setPosition('up',e);
    });

    setConnection();
}
function Figure(x,y,x1,y1)
{
    var  self = this;
    self.x  = x;
    self.y  = y;
    self.x1 = x1;
    self.y1 = y1;
    this.draw = function () {
        ctx.beginPath();
        ctx.lineWidth = 3;
        ctx.moveTo(self.x,self.y);
        ctx.lineTo(self.x1,self.y1);
        ctx.strokeStyle = "#000000";
        ctx.closePath();
        ctx.stroke();
    }
}
function setPosition(rez,ev)
{
    if(rez=='down')
    {
        currentX = ev.clientX - canvas.offsetLeft;
        currentY = ev.clientY - canvas.offsetTop;
    }

    if(rez=='up')
    {
        prevX    = currentX;
        prevY    = currentY;
        currentX = ev.clientX - canvas.offsetLeft;
        currentY = ev.clientY - canvas.offsetTop;
        if(rooms.length!=0)
        {
            var txt  = select.options[select.selectedIndex].innerText;
            var line = new Figure(prevX, prevY, currentX, currentY);
            sendMessage("draw:" + txt + ":" + JSON.stringify(line));
        }
    }
}
function PaintRoom(roomsName, story)
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
                drawing(item);
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

    var room = new PaintRoom(roomsName,"");
    var tempJson = JSON.stringify(room);
    console.log("tempJson: " + tempJson);
    rooms.push(room);

    sendMessage("newRoom:" + roomsName);
    CreateOption(roomsName);

    console.log("roomsName: " + roomsName);
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
                rooms.push(new PaintRoom(item.roomsName,item.story));
                CreateOption(item.roomsName);
                console.log(rooms);
            });
            break;

        case newRooms :
            var newRoom = JSON.parse(tempObj);
            rooms.push(new PaintRoom(newRoom.roomsName,newRoom.story));
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
                        drawing(room);
                    }
                }
            });
        } break;
    }
}
function drawing(room)
{
    ctx.strokeStyle = "white";
    ctx.fillStyle = "white";
    ctx.fillRect(0, 0, canvas.width, canvas.height);
    var objects = room.story.split(";");
    for(var i = 0; i < objects.length-1; i++)
    {
        var temp = JSON.parse(objects[i]);
        var line = new Figure(temp.x,temp.y,temp.x1,temp.y1);
        line.draw();
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
    ws.send("PaintModule:" + message);
}