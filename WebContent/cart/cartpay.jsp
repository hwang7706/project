<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");
 //   String name = (String)request.getAttribute("name");
 //   String email = (String)request.getAttribute("email");
 //  String phone = (String)request.getAttribute("phone");
 //  String address = (String)request.getAttribute("address");
  //  int totalPrice = (int)request.getAttribute("totalPrice");
     String name = (String)request.getParameter("name");
     String email = (String)request.getParameter("email");
     String tel = (String)request.getParameter("tel");
     String address = (String)request.getParameter("address");
     String totalPrice = (String)request.getParameter("total");  
     //String[] objs = request.getParameter("product_id").split("-");
     
     
     
     System.out.println("name: "+name);
     System.out.println("email: "+email);
     System.out.println("tel: "+tel);
     System.out.println("address: "+address);                                                                  
     System.out.println("totalPrice: "+totalPrice);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제페이지</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="/js/cartList_js.js"></script>
</head>
<body>
    <script>
    $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp19079238'); // 'iamport'에서 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '굿즈샵',
            amount : <%=totalPrice%>,
            buyer_email : '<%=email%>',
            buyer_name : '<%=name%>',
            buyer_tel : '<%=tel%>',
            buyer_addr : '<%=address%>',
            buyer_postcode : '123-456',
            //m_redirect_url : 'http://www.naver.com'
            
        }, function(rsp) {
            if ( rsp.success ) {
               var msg = "결제 완료";
               
               msg += '고유ID : ' + rsp.imp_uid;
               msg += '상점 거래ID : ' + rsp.merchant_uid;
               msg += '결제 금액 : ' + rsp.paid_amount;
               msg += '카드 승인번호 : ' + rsp.apply_num;
               
               location.href="/cart/paySuccess.do?totalPrice="+<%=totalPrice%>+"&email="+<%=email%>+"&tel="+<%=tel%>+"addr="+<%=address%>+"";
               
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>/order/payFail";
            }
            alert(msg);
        });
    });
    </script> 
 
</body>
</html>