/**
 * Created by pgolovenkov on 31.03.17.
 */
window.tableau = window.tableau || {};

(function () {
  // Don't run this script again if we've already loaded the JavaScript API.
  if (window.tableau._apiLoaded) {
    return;
  }

  // Set a flag so we only load once.
  window.tableau._apiLoaded = true;

  function getScriptPath(scriptName) {
    // var scripts = document.getElementsByTagName("script");
    // for (var i = 0; i < scripts.length; i++) {
    //   var src = scripts[i].src;
    //   if (src.search(scriptName) > 0) {
    //     var slashIndex = src.lastIndexOf("/");
    //     if (slashIndex >= 0) {
    //       return src.substring(0, slashIndex + 1);
    //     }
    //   }
    // }
    return "https://tableau.luxoft.com/javascripts/api/";
  }

  function loadScript(src) {
    document.write('<script src="' + src + '"></script>');
  }

  // Load the current version of the API into the page.
  loadScript(getScriptPath("tableau-2.js") + "tableau-2.1.1.js");
})();
