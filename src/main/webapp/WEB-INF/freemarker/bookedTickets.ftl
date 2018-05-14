<#include "*/header.ftl">

<!DOCTYPE html>
<html lang="en">
<body>
<h2>Booked tickets</h2>
	<table border=1>
		 <tr>
	  		<th>event</th>
	  		<th>dateTime</th>
	  		<th>price</th>
	  	    <th>seats</th>
	  	</tr>
	  <#list tickets as ticket>
	    <tr>
	    	<td>${ticket.event.name}</td>
	    	<td>${ticket.dateTime}</td>
	        <td>${ticket.price}</td>
	        <td>${ticket.seats}</td>
	    </tr>
	  </#list>
	</table>
	</br>
	<#if tickets?size != 0 >
			<button onclick="window.location='<@spring.url "pdf/ticketsforuser?userId=${userId}" />'">Print tickets to PDF</button> </br>
	</#if>

	<p><div> Time: ${time} </div>
</body>
</html>