$(function () {
    $('#btSearch').click(function () {
        /*var checkDate = $('#checkDate').val();
        var orderNo = $('#orderNo').val();
        var sortFiled = $('#sortFiled').val();
        var hotelSeq = $('#hotelSeq').val();*/
        var tbody = window.document.getElementById("tbody-result");

        $.ajax({
            type: "get",
            /*dataType: "json",
            contentType: "application/json;charset=utf-8",*/
            url: "http://localhost:8080/read?path=E:\\upload\\zhb.xlsx",
            /*data: "{\"hotelSeq\":\"" + hotelSeq
            + "\",\"orderNo\":\"" + orderNo
            + "\",\"sortFiled\":\"" + sortFiled
            + "\",\"checkDate\":\"" + checkDate
            + "\"}",*/
            success: function (data) {
                var str = "";
                for (i in data) {
                    str += "<tr>" +
                        "<td align='center'>" + data[i].code + "</td>" +
                        "<td align='center'>" + data[i].message + "</td>" +
                        /*"<td align='center'>" + data[i].orderNo + "</td>" +
                         "<td align='center'>" + data[i].userPhone + "</td>" +
                         "<td align='center'>" + data[i].createTime + "</td>" +
                         "<td align='center'>" + data[i].userId + "</td>" +
                         "<td align='center'>" + data[i].cellid + "</td>" +
                         "<td align='center'>" + data[i].gpsCity + "</td>" +
                           */
                         "</tr>";
                    }
                    tbody.innerHTML = str;
                }
            })
        });
});
