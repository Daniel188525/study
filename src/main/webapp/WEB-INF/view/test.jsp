<html>
<body>
	<h2>This is test view !</h2>
	<table>
		<tbody>
			<tr>
				<th>
					<form id="form" action="/study/test2" method="post">
						<label for="id">id:</label> <input type="text" id="id" name="id"
							value="${ user.id }" /><br /> <label for="name">name:</label> <input
							type="text" id="name" name="name" value="${ user.name }" /><br />
						<input type="submit" value="submit" />
					</form>
				</th>
			</tr>
			<tr>
				<th>
					<form id="form" action="/study/testUpload" enctype="multipart/form-data" method="post">
						<input type="file" size="79" name="uploadFile" ><br />
						<input type="submit" value="submit" />
					</form>
				</th>
			</tr>
		</tbody>
	</table>

</body>
</html>
