<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
< html
xmlns = "http://www.w3.org/1999/xhtml" >
< head >
< meta
http - equiv = "Content-Language"
content = "zh-cn" / >
< meta
http - equiv = "Content-Type"
content = "text/html; charset=gb2312" >
< title > 用鼠标滚轮滚动控制图片的缩小放大 < / title >
< script
language = "javascript" >
function bbimg(o) {
var zoom = parseInt(o.style.zoom, 10) || 100;
zoom += event.wheelDelta / 12;
if (zoom > 0) o.style.zoom = zoom + '%';
return false;
}
< / script >
< / head >
< body >
< p > 将鼠标放在图片上
，
点击一下
，
然后滚动鼠标滚轮试试看 < / p >
< p > < img
border = "0"
src = "/images/m01.jpg"
onmousewheel = "return bbimg(this)" > < / p >

</body>
</html>
