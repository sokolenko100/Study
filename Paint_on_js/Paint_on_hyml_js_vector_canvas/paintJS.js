    var canvas, ctx, flag = false, rectFlag = false,
       	currentX=0,
		currentY=0,
		prevX=0,
		prevY=0, 
		color = setColor(3);
		sizeLine =3;
		var lines = [];
		function PLine(x0, y0, x, y, color, sizeLine)
		{
			this.x0 = x0;
			this.y0 = y0;
			this.x = x;
			this.y = y;
			this.color = color;
			this.sizeLine = sizeLine;

			this.draw = function ()
			{	
			ctx.beginPath();
			ctx.lineWidth = sizeL(sizeLine);
			ctx.moveTo(x,y);
			ctx.lineTo(x0,y0);
			ctx.strokeStyle = color;
			ctx.closePath();
			ctx.stroke();	
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
			currentX= ev.clientX - canvas.offsetLeft;
			currentY= ev.clientY - canvas.offsetTop;

		//	ctx.beginPath();
          //  ctx.fillRect(currentX, currentY, 2, 2);
		//	ctx.closePath();
		//	ctx.fill();
		}
	
		if(rez=='up'||rez=='out')
		{
			flag = false;
		}
		if(rez=='move')
		{
			if(flag)
			{
				prevX=currentX;
				prevY=currentY;
				currentX= ev.clientX - canvas.offsetLeft;
				currentY= ev.clientY - canvas.offsetTop;
				lines.push(new PLine(prevX, prevY, currentX, currentY, color,sizeLine ));

				drawing();
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
		for(var i = 0; i < lines.length; i++)
        {
            lines[i].draw();
        }
   }
