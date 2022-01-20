function getIframUrl(iframeID){
    var url = parent.document.getElementById(iframeID).contentWindow.location.href;
    return url;
}
