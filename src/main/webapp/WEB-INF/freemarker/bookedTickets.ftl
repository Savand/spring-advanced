<!DOCTYPE html>
<html lang="en">
<body>
<h2>Booked tickets</h3>
	<table border=1>
		 <tr>
	  		<th>event</th>
	  		<th>dateTime</th>
	  		<th>price</th>
	  	    <th>seats</th>
	  	</tr>
	  <#list bookedTickets as ticket>
	    <tr>
	    	<td>${ticket.event}</td>
	    	<td>${ticket.dateTime}</td>
	        <td>${ticket.price}</td>
	        <td>${ticket.seats}</td>
	    </tr>
	  </#list>
	</table>
	<p><div> Time: ${time} </div>
</body>
</html>