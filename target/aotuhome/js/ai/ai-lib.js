function getNowDateFormate(now) {
    strTime = now.toLocaleString();
    strYear = now.getYear();
    strMonth = now.getMonth();
    strDay = now.getDay();

    displayTime = strYear + "-" + strMonth + "-" + strDay;
    if (strTime.substring(5, 6) < 10) {
        displayTime = strTime.substring(0, 4) + "-0" + strTime.substring(5, 6) + "-" + strTime.substring(7, 9);
    } else {

        displayTime = strTime.substring(0, 4) + "-" + strTime.substring(5, 7) + "-" + strTime.substring(8, 10);
    }
    return displayTime;
}

(function($){
    $.getUrlParam = function(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r!=null) return decodeURI(r[2]); return null;
    }
})(jQuery);


(function($){
    $.toCamel = function (inStr){
        var s =  inStr.replace(/_(\w)/g, function(all, letter){return letter.toUpperCase();});
        return s;
    }
})(jQuery);

(function($){
    $.toSplitName = function (inStr){
        var s = inStr.replace(/([A-Z])/g,"_$1").toLowerCase();
        return s;
    }
})(jQuery);