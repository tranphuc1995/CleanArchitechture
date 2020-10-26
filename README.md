# LineTest1
_ Application uses Clean Architechture with three main layers: data, domain, presentation (home_page).<br />
_ Main Flow of Application:<br />
<br />
 + if image doesn't exist in disk cache -> download and save it to disk cache, then decodes file to bitmap -> stores in memory cache -> push bitmap to view.<br />
 + if image exists in disk cache: check whether it exists in memory cache or not. If exist -> push to view, if not exist -> decodes file to bitmap -> stores in memory cache -> push bitmap to view.<br />
 <br />
&ast;&ast;&ast; Note: I don't know why i can't run apk on your virtual machine althought it runs normally in my real device when i install it. I don't have any error logs on your virtual device to check. Please take a look at this point for me. Thanks 

