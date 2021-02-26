/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.com.xuxiaowei.utils.rsa;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.util.Arrays;

/**
 * RSA 非对称加密签名 测试类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public class RsaSignatureTests {

    /**
     * 需要加密的数据
     */
    private final String DATA = "今天中午吃啥呢？？？";

    @Test
    public void privateKeySignBytePublicKeyVerifySign() throws Exception {

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
    }

    /**
     * 私钥签名，公钥验证签名
     */
    @Test
    public void privateKeySignBytePublicKeyVerifySignByte() throws Exception {

        Rsa.ByteKey byteKey = Rsa.getByteKey();

        byte[] publicKeyByte = byteKey.getPublicKey();
        byte[] privateKeyByte = byteKey.getPrivateKey();

        byte[] publicKeyEncryptByte = Rsa.publicKeyEncryptByte(publicKeyByte, DATA.getBytes());
        byte[] privateKeyDecryptByte = Rsa.privateKeyDecryptByte(privateKeyByte, publicKeyEncryptByte);

        byte[] signByte = RsaSignature.signByte(privateKeyByte, publicKeyEncryptByte);

        boolean publicKeyVerifySign = RsaSignature.verifySignByte(publicKeyByte, publicKeyEncryptByte, signByte);

        System.err.println("公钥（byte）：\t" + Arrays.toString(publicKeyByte));
        System.err.println("公钥（String）：\t" + Base64.encodeBase64String(publicKeyByte));
        System.err.println("私钥（byte）：\t" + Arrays.toString(privateKeyByte));
        System.err.println("私钥（String）：\t" + Base64.encodeBase64String(privateKeyByte));
        System.err.println("公钥加密前的数据：\t\t\t" + DATA);
        System.err.println("公钥加密后的数据（byte）：\t" + Arrays.toString(publicKeyEncryptByte));
        System.err.println("公钥加密后的数据（String）：\t" + Base64.encodeBase64String(publicKeyEncryptByte));
        System.err.println("私钥解密后的数据（byte）：\t" + Arrays.toString(privateKeyDecryptByte));
        System.err.println("私钥解密后的数据（String）：\t" + new String(privateKeyDecryptByte));
        System.err.println();
        System.err.println("私钥签名（byte）：\t" + Arrays.toString(signByte));
        System.err.println("私钥签名（String）：\t" + Base64.encodeBase64String(signByte));
        System.err.println("公钥验证签名：\t\t" + publicKeyVerifySign);
        System.err.println();
    }

}
