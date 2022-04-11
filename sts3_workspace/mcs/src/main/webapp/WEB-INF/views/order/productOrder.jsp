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

<article class="one">
	<h2>MCS ORDER</h2>
<%-- 장바구니용 	<c:forEach> --%>
	<section class="order-sheet">
		<div class="order-info">
			<div>
				<img src="/images/${product.files.file_name}">
				<div>
					<b>${product.pro_name}</b>
					<p>${product.pro_stock}<br>수량 : ${count}개</p>
  					<h5>${totalPrice}원</h5>
				</div>
			</div>
        </div>
	</section>
<%-- 	장바구니용 </c:forEach> --%>
</article>

    <article class="two">
        <section class="cs-infor-2">
        
<c:choose>
	<c:when test="${product != null}"> 
	
	<!-- order_info
ORDERNUM	NUMBER			No		1	주문번호
USERID	VARCHAR2(20 BYTE)	No		2	회원 아이디
NAME	VARCHAR2(14 BYTE)	No		3	수령인
PHONE	VARCHAR2(20 BYTE)	No		4	연락처
ADDR_NUM	VARCHAR2(5 BYTE)No		5	우편번호
ADDR	VARCHAR2(200 BYTE)	No		6	주소
ADDR2	VARCHAR2(50 BYTE)	No		7	상세주소
ORDER_DATE	DATE	No	sysdate 	8	주문날짜


order_detail
DETAILNUM	CHAR(12 BYTE)	No		1	주문상세번호
PRONUM		NUMBER			No		2	제품번호
ORDERNUM	NUMBER			No		3	주문번호
PAY_METHOD	VARCHAR2(20 BYTE)No		4	결제수단
ORDER_STACK	NUMBER		No		5	수량
PRICE		NUMBER			No		6	가격
STATE		VARCHAR2(20 BYTE)No		7	배송상태
PAY_REFUND	CHAR(1 BYTE)	No		8	환불가능여부 -->
	
	</c:when>
	<c:otherwise>
		장바구니용 forEach문으로 값 뿌려주기
	</c:otherwise>
</c:choose>

<form action="/product/order" method="post" class="order_form">

<!-- 주문정보 order_info테이블 -->
            <div><input type="text" name="name" placeholder="수령인" onClick="removeContent()"></div>
            <div><input type="text" name="phone" placeholder="수령인 연락처" onClick="removeContent()"></div>
            <div><div>받는사람 주소<input type="text" name="addr_num" value="${member.addr_num}" onClick="removeContent()"><button>검색</button></div>
                <input type="text" name="addr" value="${member.addr}"><br>
                <input type="text" name="addr2" value="${member.addr2}"></div>
<!-- 주문정보 END -->
            
            <select name="request">
                <option selected>배송 메모를 선택해주세요.</option>
                <option>부재시 경비실에 맡겨주세요.</option>
                <option>부재시 연락을 남겨주세요.</option>
                <option>문앞에 놓아주세요.</option>
            </select>
        </section>
    </article>



    <article class="three">

        <section class="order-sheet">
            <div class="order-info">
            <fmt:parseNumber var= "salePrice" integerOnly= "true" value= "${product.price-(product.price*product.sale/100)}"/>
                <div>
                    <img src="https://www.yunjac.com/public/2020/09/28/10/12/34/78a5bb8d-b333-4cca-b962-10c87ef4ed92.png">
                    <div>
                        <b>${product.pro_name}</b>
                        <p>용량 : 150ml<br>수량 : ${count}개</p>
                        <h5>60,000원</h5>
                    </div>
                </div>

                <div>
                    <div><span>상품금액</span><strong>${product.price*count}원</strong></div>
                    <div><span>배송비</span><strong>0원</strong></div>
                    <div><span>상품할인금액</span><strong>${product.price*product.sale/100}원</strong></div>
                    <div><span>주문할인금액</span><strong>0원</strong></div>
                    <div><span>총 결제 예정 금액</span><strong>${salePrice}원</strong></div>

                    <li>장기간 장바구니에 보관하신 상품은 시간이 지남에 따라 가격과 혜택이 변동 될 수 있으며, 최대 30일동안 보관됩니다.</li>
                </div>

            </div>
        </section>


        <section class="cs-infor-3">
            
            <div class="table-plus">
                <input type="checkbox" name="accordion" id="answer01">
                <label for="answer01">주문고객정보<small>+</small></label>
                <div>
                    <p><span>이름</span>${member.name}</p>
                    <p><span>연락처</span>${member.phone}</p>
                </div>

                <input type="checkbox" name="accordion" id="answer02">
                <label for="answer02">배송지 정보<small>+</small></label>
                <div>
                    <p><span>주소</span>${member.addr}</p>
                    <p><span>나머지주소</span>${member.addr2}</p>
                </div>

                <input type="checkbox" name="accordion" id="answer03">
                <label for="answer03">결제수단 선택<small>+</small></label>
                <div>
                    <button>💳 신용카드</button>
                    <button>💵 실시간 계좌 이체</button>
                </div>
            </div>

<!-- 주문상세정보 order_detail테이블 -->
			<input type="number" name="pronum" value="${product.pronum}">
			<input type="number" name="order_count" value="${count}">
			<input type="number" name="price" value="${totalPrice}">
			<input type="number" name="amount" value="${totalPrice}">
<!-- 주문상세정보 END -->
            <div>
                <button class="btn_buy">${totalPrice}원 결제하기</button>
            </div>
        </section>
</form>

</article>


    <script>
    /* 바로구매 버튼 */
	$(".btn_buy").on("click", function(){
		
		$(".order_form").submit();
	});
    
    
        /*pc헤더 픽스*/
        var prevScrollpos = window.pageYOffset;
        window.onscroll = function() {
            var currentScrollPos = window.pageYOffset;
            if (prevScrollpos > currentScrollPos) {
                document.getElementById("header").style.top = "0";
            } else {
                document.getElementById("header").style.top = "-80px";
            }
            prevScrollpos = currentScrollPos;
        }

        //table-plus
        $(".menu-list").find(".accordion-toggle").click(function() {
            $(this).next().toggleClass("open").slideToggle("fast");
            $(this).toggleClass("active-tab").find(".menu-link").toggleClass("active");

            $(".menu-list .accordion-content").not($(this).next()).slideUp("fast").removeClass("open");
            $(".menu-list .accordion-toggle").not(jQuery(this)).removeClass("active-tab").find(".menu-link").removeClass("active");
        });

        const trigger = new ScrollTrigger.default({
            trigger: {
                once: true,
                offset: {
                    element: {
                        x: 0,
                        y: 0.5
                    },
                }
            }
        });
        trigger.add('[data-trigger]')


        AOS.init({
            easing: 'ease-out-back',
            duration: 1000
        });
        
        var flag = 1;
        function removeContent() {
            if (flag == 1) {
                $("#name").val("");
                flag = 0;
            }
        }
        
        $(function() {
            $(".red-1").css({
                display: "block"
            });
            $(".plus_btn").click(function() {
                var cname = $(this).attr("id");
                $(".plus_show").css({
                    display: "none"
                });
                $("." + cname).css({
                    display: "block"
                });
            })
        })
    </script>
    

</body>

</html>