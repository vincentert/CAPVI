function ongletResultat(n, litag) {

	  var prerequis= "none";
	  var modules= "none";
	  
	  switch(n) {
	    case 1:
	    	modules= "inline";
	      break;
	    case 2:
	    	prerequis = "inline";
		  break;
	    default:
	      break;
	  }

	  document.getElementById("modul").style.display = modules;
	  document.getElementById("prere").style.display = prerequis;
	  
	  var choix = document.getElementById("choix_resultat");
	  var ca = Array.prototype.slice.call(choix.querySelectorAll("li"));
	  
	  ca.map(function(elem) {
	    elem.style.background="#e5E5E5E5";
	    elem.style.borderBottom="1px solid gray"
	  });

	  litag.style.borderBottom = "1px solid white";
	  litag.style.background = "white";
}

function selInit() {
	  var tabs = document.getElementById("choix_resultat");
	  var litag = tabs.querySelector("li");   // first li
	  litag.style.borderBottom = "1px solid white";
	  litag.style.background = "white";
}


window.onload=function() {
	selInit()
}