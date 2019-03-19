<script src="assets/vendors/jquery-2.1.1.min.js"></script>
<script src="assets/vendors/materialize/materialize.min.js"></script>

<script>
    $(document).ready(function () {
        $(".dropdown-button").dropdown();
        $('.carousel').carousel({indicators: true, duration: 200});
        $('select').formSelect();
        $('.tooltipped').tooltip();
        $('.datepicker').datepicker({format: "yyyy-m-d"});
        $('.sidenav').sidenav();
        setTimeout(autoplayCaroussel, 10000);
        function autoplayCaroussel() {
            $('.carousel').carousel('next');
            setTimeout(autoplayCaroussel, 10000);
        }
    });
</script>