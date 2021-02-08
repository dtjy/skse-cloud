http://www.ruanyifeng.com/blog/2018/07/json_web_token-tutorial.html  
JWT 的原理是，服务器认证以后，生成一个 JSON 对象，发回给用户,它是一个很长的字符串，中间用点（.）分隔成三个部分。  

Header（头部）  
Payload（负载）  
Signature（签名）  

Header.Payload.Signature

Header 部分是一个 JSON 对象，描述 JWT 的元数据  
{
  "alg": "HS256",
  "typ": "JWT"
}       
alg属性表示签名的算法（algorithm），默认是 HMAC SHA256（写成 HS256）；typ属性表示这个令牌（token）的类型（type），JWT 令牌统一写为JWT。        
Payload 部分也是一个 JSON 对象，用来存放实际需要传递的数据。JWT 规定了7个官方字段，供选用。你还可以在这个部分定义私有字段  
iss (issuer)：签发人  
exp (expiration time)：过期时间  
sub (subject)：主题    
aud (audience)：受众  
nbf (Not Before)：生效时间  
iat (Issued At)：签发时间  
jti (JWT ID)：编号  

Signature 部分是对前两部分的签名，防止数据篡改。  
定一个密钥（secret）。这个密钥只有服务器才知道，不能泄露给用户。然后，使用 Header 里面指定的签名算法（默认是 HMAC SHA256），按照下面的公式产生签名。  
HMACSHA256(  
  base64UrlEncode(header) + "." +  
  base64UrlEncode(payload),  
  secret)  
  
客户端收到服务器返回的 JWT，可以储存在 Cookie 里面，也可以储存在 localStorage。  
客户端每次与服务器通信，都要带上这个 JWT。你可以把它放在 Cookie 里面自动发送，但是这样不能跨域，所以更好的做法是放在 HTTP 请求的头信息Authorization字段里面。  

  
