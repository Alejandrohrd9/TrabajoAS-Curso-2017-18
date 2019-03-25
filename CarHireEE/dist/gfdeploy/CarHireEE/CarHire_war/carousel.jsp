<br>
<div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 900px; margin: 0 auto">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="carousel-item active">
            <div class="container">
                <img class="mySlides d-block w-75" style="margin:0 auto;" src="images/j.jpg" width="750" height="400" alt="FJeep Renegade">
            </div>
        </div>
        <div class="carousel-item">
            <div class="container">
                <img class="mySlides d-block w-75 " style="margin:0 auto;" src="images/p.jpg"  width="750" height="400" alt="Fiat Punto">
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<script>
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {
            myIndex = 1
        }
        x[myIndex - 1].style.display = "block";
        setTimeout(carousel, 500); // Change image every 2 seconds
    }
</script>