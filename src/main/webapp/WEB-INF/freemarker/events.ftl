<#include "*/header.ftl">


<h2>Events</h2>
<#if events?size == 0>
 		There no events in the system
<#else>

		<table border=1>
            <tr>
                <th>Name</th>
                <th>dateTime</th>
                <th>auditorium</th>
            </tr>
		  <#list events as event>
		    <tr>
                <td>${event.name}</td>
                <td>${event.dateTime}</td>
                <td>${event.auditorium}</td>
            </tr>
          </#list>
        </table>

</#if>


	
	
	<p>
<div> Time: ${time} </div>
</body>
</html>