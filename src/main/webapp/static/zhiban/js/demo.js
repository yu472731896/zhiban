(function() {
	$(function() {
		$(".goleft").click(function(){
			window.location.href ="javascript:history.back(-1)"
		});
		$(".gohome").click(function(){
			window.location='index.html'
		});
	});
})();