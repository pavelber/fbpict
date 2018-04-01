function toDate(timestamp){
    let date = new Date(timestamp);
    return date.toDateString()
}
$(document).ready(function () {

    jQuery.getJSON("/duplicates?"+window.location.search.substring(1) , function (data) {
        let $table = $("#duplicates");
        for(let i in data){
            let datum = data[i];
            $table.append('<tr>' +
                (datum.imageUrl? '<td><IMG SRC="'+datum.imageUrl+'"></td>' :'')+
                '</td><td><A HREF="'+datum.url+'"> '+toDate(datum.urlDate)+'</A></td>' +
                (datum.origImageUrl?'<td><IMG SRC="'+datum.origImageUrl+'"></td>':'' )+
                '<td><A HREF="'+datum.original+'"> '+toDate(datum.originalDate)+'</A></td>' +
                '</tr>')


        }
    });

});
