<div id="client_cnx_box" class="row">
	<div class="col-sm-6 client_con">
		<h4>Vous avez déja un compte?</h4>
		<form class="form-1" method="POST" action="/jebouquine/login">
			<p class="field">
				<input type="text" name="username" placeholder="Username or email">
				<i class="icon-user icon-large"></i>
			</p>
			<p class="field">
				<input type="password" name="password" placeholder="Password">
				<i class="icon-lock icon-large"></i>
			</p>
			<button type="submit" class="btn btn-primary">
				connexion <span class="glyphicon glyphicon-ok"></span>
			</button>
		</form>

	</div>
	<div class="col-sm-6 client_con">
		<div id="sign_up_box">
			<h4>Vous êtes un nouveau client ?</h4>
			<p>
				En créant un compte sur notre boutique, <br> vous pourrez
				passer vos commandes plus rapidement!
			</p>
			<a href="#/signup">
				<button type="button" class="btn btn-primary">
					s'enregistrer <span class="glyphicon glyphicon-ok"></span>
				</button>
			</a>
		</div>

	</div>
</div>
