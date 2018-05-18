
<%@include file="header.jsp"%>

<%@page import="servini.bean.Commercant"%>
<%@page import="servini.bean.Client"%>
<%@page import="java.util.*"%>


<div>
	<ul class="breadcrumb">
		<li><a href="#">Home</a></li>
		<li><a href="#">Tables</a></li>
	</ul>
</div>

<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well" data-original-title="">
				<h2>
					<i class="glyphicon glyphicon-user"></i> Datatable + Responsive
				</h2>

				<div class="box-icon">
					<a href="#" class="btn btn-round btn-default"><i
						class="glyphicon glyphicon-cog"></i></a> <a href="#"
						class="btn btn-minimize btn-round btn-default"><i
						class="glyphicon glyphicon-chevron-up"></i></a> <a href="#"
						class="btn btn-close btn-round btn-default"><i
						class="glyphicon glyphicon-remove"></i></a>
				</div>
			</div>
			<div class="box-content">
				<div class="alert alert-info">
					For help with such table please check <a
						href="http://datatables.net/" target="_blank">http://datatables.net/</a>
				</div>
				<table
					class="table table-striped table-bordered bootstrap-datatable datatable responsive">
					<thead>
						<tr>
							<th>Nom - Prenom</th>
							<th>Adresse</th>
							<th>Email</th>
							<th>Tel</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Client> lcients = new ArrayList<>();
							boolean flag = (request.getSession().getAttribute("Commercant") == null);
							if (!flag) {
								if (request.getParameter("usr").equals("Commercant")) {
									Commercant c = (Commercant) request.getSession().getAttribute("Commercant");
									lcients = c.getClient();
								}
							} else {
								Client c = new Client();
								lcients.add(c);
							}
							for (Client c : lcients) {
						%>
						<tr>
							<td><%=c.getNom() + " " + c.getPrenom()%></td>
							<td class="center"><%=c.getAdresse()%></td>
							<td class="center"><%=c.getEmail()%></td>
							<td class="center"><span
								class="label-success label label-default"><%=c.getTel()%></span></td>
							<td class="center"><a class="btn btn-setting btn-success"
								href="" onclick="f1(<%=c%>);"> <i
									class="glyphicon glyphicon-zoom-in icon-white"></i> View
							</a> <a class="btn btn-info" href="#"> <i
									class="glyphicon glyphicon-edit icon-white"></i> Edit
							</a> <a class="btn btn-danger" href="#"> <i
									class="glyphicon glyphicon-trash icon-white"></i> Delete
							</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!--/span-->
</div>
<!--/span-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">

	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				
				<p id="demo"></p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn btn-default" data-dismiss="modal">Close</a> <a
					href="#" class="btn btn-primary" data-dismiss="modal">Save
					changes</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function f1(a) {
	document.getElementById("demo").innerHTML = a;
}

</script>

<%@include file="footer.jsp"%>
