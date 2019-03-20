"use-strict"

$(document).ready(function () {
	function initMaterialize() {
		$(".dropdown-button").dropdown();
		$('.carousel').carousel({indicators: true, duration: 200});
		$('select').formSelect();
		$('.tooltipped').tooltip();
		$('.datepicker').datepicker({format: "yyyy-m-d"});
		$('.sidenav').sidenav();

		setTimeout(autoplayCaroussel, 10000);
		
		createMobileMenu();
	}
	
	function autoplayCaroussel() {
		$('.carousel').carousel('next');
		setTimeout(autoplayCaroussel, 10000);
	}
	
	function createMobileMenu() {
		let menu = $("#mobileNav");
		$(".menu li").each(function() {
			menu.append($(this).clone());
		});
	}
	
	initMaterialize();
});