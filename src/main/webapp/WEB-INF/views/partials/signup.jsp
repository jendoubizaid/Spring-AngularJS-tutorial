<div id="client_cnx_box" class="row" align=center>
<div class="col-sm-12">
<div id="sign_up_form">
  <h4>créer un compte</h4>
 <form class="form-1">
  <p class="field">
        <input type="text" placeholder="type your Username" id="nom" ng-model="user.nom">
    <i class="icon-user icon-large"></i>
  </p>
  <p class="field">
        <input type="text"  placeholder="type your lastname"  id="prenom" ng-model="user.prenom"/>
    <i class="icon-user icon-large"></i>
  </p>
  <p class="field">
        <input type="email" placeholder="type your email" id="email" ng-model="user.email">
    <i class="icon-user icon-large"></i>
  </p>
  <p class="field">
        <input type="login" placeholder="type your login"  id="login" ng-model="user.login">
    <i class="icon-user icon-large"></i>
  </p>
  <p class="field">
        <input type="password" placeholder="type your password"  id="pwd" ng-model="user.passwd">
    <i class="icon-user icon-large"></i>
  </p>
 <a class="btn btn-primary" ng-click="addUser()"> valider <span class="glyphicon glyphicon-ok"></span> </a>            
 </form>

</div>
 </div>
</div>

