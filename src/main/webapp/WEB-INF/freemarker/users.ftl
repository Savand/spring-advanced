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
		  		<th>Roles</th>
		  		<th>Password</th> <!-- remove -->
		  	</tr>
		  <#list users as user>
		    <tr>
		    	<td>${user.name}</td>
		    	<td>${user.email}</td>
		        <td>${user.birthday}</td>
		        <td>${user.roles}</td>
		        <td>${user.password}</td> <!-- remove -->
		    </tr>
		  </#list>
		</table>
	
	</#if>


	
	
	<p><div> Time: ${time} </div>
</body>
</html>