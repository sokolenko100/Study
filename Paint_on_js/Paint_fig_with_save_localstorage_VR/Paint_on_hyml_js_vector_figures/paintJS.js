		document.addEventListener("DOMContentLoaded", init);
		var canvas, ctx, flag = false, rectFlag = false,
		typeF,
       	currentX=0,
		currentY=0,
		prevX=0,
		prevY=0, 
		color = "black",
		sizeLine =3;
		var keys = [];
		var lableVal;
		var figures = [];
		var table;
		function PFigure(x0, y0, x1, y1, color,type, sizeLine)
		{
			this.type = type;
			this.x0 = x0;
			this.y0 = y0;
			this.x1 = x1;
			this.y1 = y1;
			this.color = color;
			this.sizeLine = sizeLine;

			this.draw = function()
			{	
				ctx.lineWidth=sizeLine;
				ctx.strokeStyle = color;
				ctx.beginPath();
			switch(type)
			{
			case "0" :
				ctx.moveTo(x0,y0);
				ctx.lineTo(x1,y1);
				ctx.stroke();
				break;
			case "1" :
				ctx.strokeRect(x0, y0,x1-x0, y1-y0);
				ctx.stroke();
				break;
			case "2":
				var x = ((x1-x0)/2)+x0;
				var y = ((y1-y0)/2)+y0;
				var r = (y1-y0)/2;
				if(r<0)
				{
				r*=-1;	
				}
				ctx.arc(x,y,r,0, Math.PI * 2, true);
				ctx.stroke();
				break;
			}
			ctx.closePath();
	
			}
		}
	function sizeL(val)
	{
		sizeLine = document.getElementById("TrackBar").value;
		return sizeLine;
	}
	function init() 
	{
		canvas = document.getElementById('canvasID');
		typeF = document.getElementById('box');
		ctx = canvas.getContext('2d');
			
		canvas.addEventListener('mousedown',function(ev)
		{
			setPosition_X_Y('down',ev);		
		});	
		canvas.addEventListener('mousemove',function(ev)
		{
			setPosition_X_Y('move',ev);	
		});
		canvas.addEventListener('mouseup',function(ev)
		{
				setPosition_X_Y('up',ev);	
		});
		canvas.addEventListener('mouseout',function(ev)
		{
			setPosition_X_Y('out',ev);	
		});
	}
	function setPosition_X_Y(rez,ev)
	{
		if(rez=='down')
		{
			flag = true;
			prevX= ev.clientX - canvas.offsetLeft;
			prevY= ev.clientY - canvas.offsetTop; 			
		}
	
		if(rez=='up')
		{
				flag = false;
				currentX= ev.clientX - canvas.offsetLeft;
				currentY= ev.clientY - canvas.offsetTop;
				var figure = new PFigure(prevX, prevY, currentX, currentY, color,typeF.value, sizeLine);
				figures.push(figure);
				drawing();
		}
		if(rez=='move')
		{
			if(flag)
			{
			}
		}
	}
	
	function setColor(colorVal)
	{
		color = document.getElementById("PalitraBleat").value;
		return color;
	}
	   function clearCanv(x)
	   {
			ctx.strokeStyle = "white";
			ctx.fillStyle = "white";
			ctx.fillRect(0, 0, canvas.width, canvas.height);
			if(x)
			{
				figures = [];	
			}
	   }
   
   function drawing()
   {
		clearCanv(false);
	    for(var i = 0; i < figures.length; i++)
        {
            figures[i].draw();
		}		
   }
function save(key)
{
	lableVal = document.getElementById("keyID").value;
    var serialObj = JSON.stringify(figures);
    localStorage.setItem(lableVal, serialObj);
}
   
    function fillTable(key)
	{
		var returnObj;

        returnObj = JSON.parse(localStorage.getItem(key));
		figures=[];
		for(var i = 0; i < returnObj.length; i++)
        {
			var figure = new PFigure(returnObj[i].x0, returnObj[i].y0, returnObj[i].x1,  returnObj[i].y1,  returnObj[i].color, returnObj[i].type,  returnObj[i].sizeLine);
            figures.push(figure);
		}
	
		drawing();
	}
	function loadKeysFromLS()
	{
		keys=[];
		for(var i = 0; i < localStorage.length; i++)
        {
            keys.push(localStorage.key(i));
		}
	}
	function load()
	{
		loadKeysFromLS();
		if(table ===undefined)
		{
			table = document.createElement('table');
			table.setAttribute('rules','All');
			table.setAttribute('id','table');
		}
		else
		{
			table.innerHTML="";
		}

		var keysLenght= keys.length;
		var row=0;
		if(keysLenght<=4)
		{
			 row =1;
		}
		else
		{
			row	=keysLenght /4;
			row+1;
		}
		
		for(var i =0, keyN=1;i<row;i++)
		{
			var row = table.insertRow(i);
			for(var j =0;j<4&&j<keysLenght;j++,keyN++)
			{
				var cell = row.insertCell(j);
				cell.innerHTML = keys[keyN];
			}	
			keysLenght=-4;
		}
		table.onclick = function(event) {
		var target = event.target; // где был клик?

		if (target.tagName != 'TD') return; // не на TD? тогда не интересует

		var	selectedTd=target.innerText;
			fillTable(selectedTd)
		};
		document.body.appendChild(table);
	}
		
