function ongletAccueilAdmin(n, litag) {

	  var parcours = "none";
	  var prerequis= "none";
	  var modules= "none";
	  
	  switch(n) {
	    case 1:
	      parcours = "inline";
	      break;
	    case 2:
	      prerequis = "inline";
	      break;
	    case 3:
		  modules= "inline";
		  break;
	    default:
	      break;
	  }

	  document.getElementById("parcour").style.display = parcours;
	  document.getElementById("prerequi").style.display = prerequis;
	  document.getElementById("module").style.display = modules;
	  
	  var choix = document.getElementById("choix_onglet");
	  var ca = Array.prototype.slice.call(tabs.querySelectorAll("li"));
	  
	  ca.map(function(elem) {
	    elem.style.background="#F0F0F0";
	    elem.style.borderBottom="1px solid gray"
	  });

	  litag.style.borderBottom = "1px solid white";
	  litag.style.background = "white";
}

function selInit() {
	  var tabs = document.getElementById("choix_onglet");
	  var litag = tabs.querySelector("li");   // first li
	  litag.style.borderBottom = "1px solid white";
	  litag.style.background = "white";
}


window.onload=function() {
	selInit()
}