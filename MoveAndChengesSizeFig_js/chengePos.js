document.addEventListener("DOMContentLoaded",init());
var canvas, ctx,timerId;
var x,y,prevX,prevY;
var ischeckSizeLeftTopCorner     = false;
var ischeckSizeLeftSide          = false;
var ischeckSizeLeftBottomCorner  = false;
var ischeckSizeBottomSide        = false;
var ischeckSizeRightBottomCorner = false;
var ischeckSizeRightSide         = false;
var ischeckSizeRightTopCorner    = false;
var ischeckSizeTopSide           = false;
var isCheked                     = false;
var sqlist;
var moveSq;
function init()
{
    canvas = document.getElementById('canvasID');
    ctx = canvas.getContext('2d');
    sqlist = new Array();
 //   timerId  = setInterval(display, 1);
    canvas.addEventListener('mousedown',function(e)
    {
        mousePressed(e);
    });
    canvas.addEventListener('mousemove',function(e)
    {
        mouseMoved(e)
    });
    canvas.addEventListener('mouseup',function(e)
    {
        mouseReleased(e)
    });
}
function display()
{
    ctx.strokeStyle = "white";
    ctx.fillStyle   = "white";
    ctx.fillRect(0, 0, canvas.width, canvas.height);

    for(var i = 0; i < sqlist.length;i++)
    {
        sqlist[i].Draw();

        if(sqlist[i].isDrawNestedSquare)
        {
            sqlist[i].CreateNastedSquare();
        }
    }
}
function mousePressed(e)
{
    x = e.clientX - canvas.offsetLeft;
    y = e.clientY - canvas.offsetTop;

    for (var i = 0; i < sqlist.length; i++)         // Check where is click mouse
    {
        isCheked 					 = sqlist[i].checkPosition(x,y);

        ischeckSizeLeftTopCorner 	 = sqlist[i].checkSizeLeftTopCorner(x, y);
        ischeckSizeLeftSide			 = sqlist[i].checkSizeLeftSide(x, y);
        ischeckSizeLeftBottomCorner  = sqlist[i].checkSizeLeftBottomCorner(x, y);
        ischeckSizeBottomSide		 = sqlist[i].checkSizeBottomSide(x, y);
        ischeckSizeRightBottomCorner = sqlist[i].checkSizeRightBottomCorner(x, y);
        ischeckSizeRightSide 		 = sqlist[i].checkSizeRightSide(x, y);
        ischeckSizeRightTopCorner 	 = sqlist[i].checkSizeRightTopCorner(x, y);
        ischeckSizeTopSide 			 = sqlist[i].checkSizeTopSide(x, y);
        if(isCheked)
        {
            moveSq = sqlist[i];                     // Takes choice square
            break;
        }
        if(ischeckSizeLeftTopCorner||ischeckSizeLeftSide||ischeckSizeLeftBottomCorner||ischeckSizeBottomSide||ischeckSizeRightBottomCorner||ischeckSizeRightSide||ischeckSizeRightTopCorner||ischeckSizeTopSide)
        {
            moveSq = sqlist[i];                     // Takes choice square
            break;
        }
    }
}
function  mouseReleased(e)
{
    display();
    if(!isCheked)                                   // Add square in array
    {
        var getX   = e.clientX - canvas.offsetLeft;
        var getY   = e.clientY - canvas.offsetTop;
        var height = getY - y;
        var width  = getX - x;

        if((height < 0) && (width < 0))
        {
            height = -height;
            width  = -width;
            sq = new  Square(x - width, y - height, width,height,this);
        }
        else if(width<0)
        {
            width = -width;
            sq = new  Square(x - width, y, width, height,this);
        }
        else if(height<0)
        {
            height = -height;
            sq = new  Square(x, y-height, width, height,this);
        }
        else
        {
            sq = new  Square(x, y, width, height,this);
        }
        sqlist.push(sq);
    }
    NullAllVar();
}

function mouseMoved(e)
{
    display();
    ///////////////////////////////////////////////
    /// Check what  square is in focus
    ///////////////////////////////////////////////
        var  getX = e.clientX - canvas.offsetLeft;
        var  getY = e.clientY - canvas.offsetTop;

        for (var i = 0; i < sqlist.length; i++)
        {
            if(sqlist[i].DrawNestedSquare(getX, getY))
            {
                var isFirstFocus = true;
                for (var j = 0; j < sqlist.length; j++)
                {
                    if((sqlist[j].isDrawNestedSquare == true) && (i != j))
                    {
                        isFirstFocus = false;
                        break;
                    }
                }
                if(isFirstFocus)
                {
                    sqlist[i].isDrawNestedSquare = true;
                }
            }
            else
            {
                sqlist[i].isDrawNestedSquare = false;
            }
        }
    ///////////////////////////////////////////////
    if(isCheked)
    {
        x = e.clientX - canvas.offsetLeft;
        y = e.clientY - canvas.offsetTop;
        if((prevX != 0) && (prevY != 0))
        {
            moveSq.movePosition(x - prevX, y - prevY );
        }
        prevX = x;
        prevY = y;
    }
    if(ischeckSizeLeftTopCorner)
    {
        x = e.clientX - canvas.offsetLeft;
        y = e.clientY - canvas.offsetTop;
        if((prevX != 0) && (prevY != 0))
        {
            moveSq.moveSizeLeftTopCorner( prevX - x, prevY - y );
        }
        prevX = x;
        prevY = y;
    }
    if(ischeckSizeLeftSide)
    {
        x = e.clientX - canvas.offsetLeft;
        y = e.clientY - canvas.offsetTop;
        if((prevX != 0) && (prevY != 0))
        {
            moveSq.moveSizeLeftSide( prevX - x ,y - prevY );
        }
        prevX = x;
        prevY = y;
    }
    if(ischeckSizeLeftBottomCorner)
    {
        x = e.clientX - canvas.offsetLeft;
        y = e.clientY - canvas.offsetTop;
        if((prevX != 0) && (prevY != 0))
        {
            moveSq.moveSizeLeftBottomCorner( prevX - x, y - prevY );
        }
        prevX = x;
        prevY = y;
    }
    if(ischeckSizeBottomSide)
    {
        x = e.clientX - canvas.offsetLeft;
        y = e.clientY - canvas.offsetTop;
        if((prevX != 0) && (prevY != 0))
        {
            moveSq.moveSizeBottomSide(x - prevX, y - prevY );
        }
        prevX = x;
        prevY = y;
    }
    if(ischeckSizeRightBottomCorner)
    {
        x = e.clientX - canvas.offsetLeft;
        y = e.clientY - canvas.offsetTop;
        if((prevX != 0) && (prevY != 0))
        {
            moveSq.moveSizeRightBottomCorner(x - prevX, y - prevY );
        }
        prevX = x;
        prevY = y;
    }
    if(ischeckSizeRightSide)
    {
        x = e.clientX - canvas.offsetLeft;
        y = e.clientY - canvas.offsetTop;
        if((prevX != 0) && (prevY != 0))
        {
            moveSq.moveSizeRightSide(x - prevX, y - prevY );
        }
        prevX = x;
        prevY = y;
    }
    if(ischeckSizeRightTopCorner)
    {
        x = e.clientX - canvas.offsetLeft;
        y = e.clientY - canvas.offsetTop;
        if((prevX != 0) && (prevY != 0))
        {
            moveSq.moveSizeRightTopCorner(x - prevX, prevY -y );
        }
        prevX = x;
        prevY = y;
    }
    if(ischeckSizeTopSide)
    {
        x = e.clientX - canvas.offsetLeft;
        y = e.clientY - canvas.offsetTop;
        if((prevX != 0) && (prevY != 0))
        {
            moveSq.moveSizeTopSide(x - prevX, prevY -y );
        }
        prevX = x;
        prevY = y;
    }
}
function  NullAllVar()
{
    ischeckSizeLeftTopCorner     = false;
    ischeckSizeLeftSide          = false;
    ischeckSizeLeftBottomCorner  = false;
    ischeckSizeBottomSide        = false;
    ischeckSizeRightBottomCorner = false;
    ischeckSizeRightSide         = false;
    ischeckSizeRightTopCorner    = false;
    ischeckSizeTopSide           = false;
    prevX                        = 0;
    prevY                        = 0;
    isCheked                     = false;
}
