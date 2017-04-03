		
		
		document.addEventListener("DOMContentLoaded", init);
		var canvas, ctx, flag = false, rectFlag = false,
		typeF;
       	currentX=0,
		currentY=0,
		prevX=0,
		prevY=0, 
		color = setColor(3);
		sizeLine =3;

		var figures = [];
		
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
				ctx.strokeStyle = "black";
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
				ctx.arc(x,y,r,0, Math.PI * 2, true);
				ctx.stroke();
				break;
			}
			ctx.closePath();
	
			}
		}
	function sizeL(val)
	{
		sizeLine  = val;
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
		var  array = ["red","yellow","green","black","gray","blue"];
		color=array[colorVal];
		return color;
	}
   function drawing()
   {
	   	ctx.strokeStyle = "white";
		ctx.fillStyle = "white";
		ctx.fillRect(0, 0, canvas.width, canvas.height);
	    for(var i = 0; i < figures.length; i++)
        {
            figures[i].draw();
        
		}		
   }
