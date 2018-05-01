<!DOCTYPE html>
<html lang="en">
<body>


<h2>Users</h3>
	<#if users?size == 0>
 		There no users in the system
	<#else>

		<table border=1>
			 <tr>
		  		<th>Name</th>
		  		<th>Email</th>
		  		<th>Birthday</th>
		  	</tr>
		  <#list users as user>
		    <tr>
		    	<td>${user.name}</td>
		    	<td>${user.email}</td>
		        <td>${user.birthday}</td>
		    </tr>
		  </#list>
		</table>
	
	</#if>


	
	
	<p><div> Time: ${time} </div>
</body>
</html>