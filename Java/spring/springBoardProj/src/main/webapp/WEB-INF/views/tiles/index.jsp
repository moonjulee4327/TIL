<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>Breeze Admin</title>
    <link rel="stylesheet" href="/resources/BreezeAdmin/template/assets/vendors/mdi/css/materialdesignicons.min.css" />
    <link rel="stylesheet" href="/resources/BreezeAdmin/template/assets/vendors/flag-icon-css/css/flag-icon.min.css" />
    <link rel="stylesheet" href="/resources/BreezeAdmin/template/assets/vendors/css/vendor.bundle.base.css" />
    <link rel="stylesheet" href="/resources/BreezeAdmin/template/assets/vendors/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" href="/resources/BreezeAdmin/template/assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.css" />
    <link rel="stylesheet" href="/resources/BreezeAdmin/template/assets/css/style.css" />
    <link rel="shortcut icon" href="/resources/BreezeAdmin/template/assets/images/favicon.png" />
  </head>
  <body>
    <div class="container-scroller">
      
      <!-- aside 시작 -->
      <tiles:insertAttribute name="aside" />
      <!-- aside 끝 -->
      
      <div class="container-fluid page-body-wrapper">
        <div id="theme-settings" class="settings-panel">
          <i class="settings-close mdi mdi-close"></i>
          <p class="settings-heading">SIDEBAR SKINS</p>
          <div class="sidebar-bg-options selected" id="sidebar-default-theme">
            <div class="img-ss rounded-circle bg-light border mr-3"></div> Default
          </div>
          <div class="sidebar-bg-options" id="sidebar-dark-theme">
            <div class="img-ss rounded-circle bg-dark border mr-3"></div> Dark
          </div>
          <p class="settings-heading mt-2">HEADER SKINS</p>
          <div class="color-tiles mx-0 px-4">
            <div class="tiles light"></div>
            <div class="tiles dark"></div>
          </div>
        </div>
        
        <!-- header 시작 -->
        <tiles:insertAttribute name="header"/>
        <!-- header 끝 -->
        
        <div class="main-panel">
          
          <!-- body 시작 -->
          <tiles:insertAttribute name="body"/>
          <!-- body 끝-->
          
          <!-- footer 시작 -->
          <tiles:insertAttribute name="footer"/>
          <!-- footer 끝 -->
          
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="/resources/BreezeAdmin/template/assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src="/resources/BreezeAdmin/template/assets/vendors/chart.js/Chart.min.js"></script>
    <script src="/resources/BreezeAdmin/template/assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
    <script src="/resources/BreezeAdmin/template/assets/vendors/flot/jquery.flot.js"></script>
    <script src="/resources/BreezeAdmin/template/assets/vendors/flot/jquery.flot.resize.js"></script>
    <script src="/resources/BreezeAdmin/template/assets/vendors/flot/jquery.flot.categories.js"></script>
    <script src="/resources/BreezeAdmin/template/assets/vendors/flot/jquery.flot.fillbetween.js"></script>
    <script src="/resources/BreezeAdmin/template/assets/vendors/flot/jquery.flot.stack.js"></script>
    <script src="/resources/BreezeAdmin/template/assets/vendors/flot/jquery.flot.pie.js"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="/resources/BreezeAdmin/template/assets/js/off-canvas.js"></script>
    <script src="/resources/BreezeAdmin/template/assets/js/hoverable-collapse.js"></script>
    <script src="/resources/BreezeAdmin/template/assets/js/misc.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <script src="/resources/BreezeAdmin/template/assets/js/dashboard.js"></script>
    <!-- End custom js for this page -->
  </body>
</html>