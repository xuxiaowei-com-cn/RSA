<div align="center">
    <h1>RSA 非对称性加密、签名工具</h1>
    <a href="https://github.com/996icu/996.ICU/blob/master/LICENSE">
        <img alt="License-Anti" src="https://img.shields.io/badge/License-Anti 996-blue.svg">
    </a>
    <a href="https://996.icu/#/zh_CN">
        <img alt="Link-996" src="https://img.shields.io/badge/Link-996.icu-red.svg">
    </a>
</div>

<p align="center">
  为简化开发工作、提高生产率而生
</p>

<p align="center">
  <a href="https://search.maven.org/artifact/cn.com.xuxiaowei.utils/rsa">
    <img alt="maven" src="https://img.shields.io/maven-central/v/cn.com.xuxiaowei.utils/rsa.svg?style=flat-square">
  </a>

  <a href="https://www.apache.org/licenses/LICENSE-2.0">
    <img alt="code style" src="https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square">
  </a>
</p>

## 示例

### 公钥加密，私钥解密，私钥签名，公钥验证签名

- 代码

```
Rsa.StringKey stringKey = Rsa.getStringKey();

String publicKey = stringKey.getPublicKey();
String privateKey = stringKey.getPrivateKey();

String publicKeyEncrypt = Rsa.publicKeyEncrypt(publicKey, DATA);
String privateKeyDecrypt = Rsa.privateKeyDecrypt(privateKey, publicKeyEncrypt);

String signByte = RsaSignature.sign(privateKey, publicKeyEncrypt);

boolean publicKeyVerifySign = RsaSignature.verifySign(publicKey, publicKeyEncrypt, signByte);

System.err.println("公钥：" + publicKey);
System.err.println("私钥：" + privateKey);
System.err.println("公钥加密前的数据：" + DATA);
System.err.println("私钥解密后的数据：" + privateKeyDecrypt);
System.err.println();
System.err.println("私钥签名：\t\t" + signByte);
System.err.println("公钥验证签名：\t" + publicKeyVerifySign);
System.err.println();
```

- 结果

```
公钥：MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCD5XD8TEL7d6EwN6WohUhLMPbx7LumqTY4hD0wHQDVB8QcOtyKiHTJEL+KnmY662gkDJnxiaeMUqX5c2AneXf3wLCYi6I8JmFqSNhOdxNdo/YvklPcmBAmxpW2grZdO4J2MWVykHrAMD07YJOKXDZcwe4HQgpoIH7hKvalcc4QnQIDAQAB
私钥：MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIPlcPxMQvt3oTA3paiFSEsw9vHsu6apNjiEPTAdANUHxBw63IqIdMkQv4qeZjrraCQMmfGJp4xSpflzYCd5d/fAsJiLojwmYWpI2E53E12j9i+SU9yYECbGlbaCtl07gnYxZXKQesAwPTtgk4pcNlzB7gdCCmggfuEq9qVxzhCdAgMBAAECgYBYoWqOL5TnNFlddFdeacnNtSaMJR9n+9cSnVIcrbCsdl6C9c7TTKTlo9qChLR/rUa6yrj7xRuQwM0FVlFr1UUWeoiYK4A7KKSMwbe5HZkj5hZM1O9T/nqXrdI+qztqUcPMoThE1W3pSJ1SuFH2NSoWyXuyYXRdoAyTwoVSVZ4WBQJBAOeqB4PlrNCVgCveabrc/WTTSuUvu42NKG7n7huaQtrDH7uy0GIumq8MwuZl+R6ZUtyxv2CA9MK0dPyPKSkDbCcCQQCRwG2g2XPgCDXyy0Sl+GOEnkf2JWKVhuGrlCf41gwJP77JPMekSrNi0Yw27c0YwdFmrtm/GKAGhL4vYtvxo+ObAkEAqkRl0aN1KLk4wwVtYFIcS4agfWJfzuH43crJTrBKgs72+9WpIwBt4ErY1M4OE1dNd7eMmTkurAxGD3qJHgPN8QJAbIQSm0GLjm9Oi1hf4hpPLfwSo+ctwRpNhsul/xSOnYxCZd3E3kNnz9koRfVDUH1thMAGCsswyemnF+zIyN42pQJAI6ZJSx+bUacrS6yhPLKJXDRrZtp7xCGLesc6kMK6Yyaa2FcQWs+XZncPEdlFxsFgOgAsBd9s+PpCv6DRFIR9Lg==
公钥加密前的数据：今天中午吃啥呢？？？
私钥解密后的数据：今天中午吃啥呢？？？

私钥签名：		fKJdYpbKPGHyBsZ6+0JZ6YAIczRT0pylkDiMwPTzKR4ihbUMdMQkI/Xlw94tWEORsxreOdOdeLaYQYG9XsyOVQuDdqi6r6yGrRcgehWzYRsl17MZir/65MY4XbhR5S1aOz/TwbsTS9QyqHzbVh/VkQHd653ecKRFnPkJCz+VOnQ=
公钥验证签名：	true
```

### JS

- [jsencrypt](https://github.com/travist/jsencrypt)

### 其他示例

- 私钥加密，公钥解密，查看测试类
- String、byte 类型的秘钥加密、解密和签名示例，查看测试类

### [spring-security-rsa](https://mvnrepository.com/artifact/org.springframework.security/spring-security-rsa)
