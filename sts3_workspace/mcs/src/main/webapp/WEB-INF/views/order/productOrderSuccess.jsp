<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=3.0">
    <title>MCS Order</title>
    <link rel="stylesheet" href="/css/order.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="script.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/ScrollTrigger/1.0.5/ScrollTrigger.min.js"></script>

    <!--폰트어썸-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

    <!-- 스르륵 -->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
</head>

<body>
    <article class="four">
        <section class="order-sheet">

            <div class="order-info">

                <div>
                    <img src="https://www.yunjac.com/public/2020/09/28/10/12/34/78a5bb8d-b333-4cca-b962-10c87ef4ed92.png">
                    <div>
                        <b>자목숙 안티에이징 토너</b>
                        <p>용량 : 150ml<br>수량 : 1개</p>
                        <h5>60,000원</h5>
                    </div>
                </div>

                <div>
                    <div><span>총 결제 금액</span><strong>60,000원</strong></div>
                    <p>주문이 완료되었습니다</p>
                </div>
            </div>
        </section>

        <div><button>결제 상세내역 보기 (링크없음)</button></div>
    </article>
</body>

</html>