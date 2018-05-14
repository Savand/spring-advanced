<#include "*/header.ftl">

<h2>Auditoriums</h2>
	<table border=1>
		 <tr>
	  		<th>Name</th>
	  		<th>Seats number</th>
	  		<th>Vip seats</th>
	  	</tr>
	  <#list auditoriums as auditorium>
	    <tr>
	    	<td>${auditorium.name}</td>
	    	<td>${auditorium.seatsNumber}</td>
	        <td>${auditorium.vipSeats}</td>
	    </tr>
	  </#list>
	</table>
	<p><div> Time: ${time} </div>
</body>
</html>