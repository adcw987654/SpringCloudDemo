# SpringCloudDemo

# 本地啟用專案
若要在本地啟用測試專案的話，  
需要額外設定本地DNS，  
原因是因為eureka server集群不能在同一個hostname啟用，  
所以需要在C:\Windows\System32\dirvers\etc\hosts裡面新增映射  
本專案將 127.0.0.1 映射到 eureka8887.com、eureka8888.com 

# 專案架構
1. cloud-api-commons : 放置所有共用的Entity，避免在每個微服務都建立重複的Class，其他服務利用pom引入此專案內容。
2. cloud-consumer-order80 : 消費服務，主要用於調用 payment 服務。
3. cloud-provider-payment8001 : 付款服務，主要用於寫入、讀取 payment table相關服務。
4. cloud-eureka-server8888 : 註冊中心服務，用於註冊服務，以及提供服務消費者所需要的服務資訊。


## 服務註冊與發現

服務註冊與發現流程中含有三個角色

* 服務註冊中心(Register Service): 用於提供服務註冊和發現功能。 (Eureka Server)
* 服務提供者(Provider Service): 用於提供服務，將自身註冊到註冊中心，以供服務消費者發現。 (Eureka Client)
* 服務消費者(Consumer Service): 用於消費服務，從註冊中心取得服務列表，使用所需的服務。 (Eureka Client)

Eureka 服務註冊中心 實際運行流程如下:
1. 搭建一個Eureka Server作為註冊中心
2. 服務提供者啟動時，把自身服務信息註冊到註冊中心
3. 服務消費者啟動時，把自身服務信息註冊到註冊中心
4. 服務消費者向註冊中心取得已註冊的服務信息列表
5. 獲得服務信息後，透過HTTP / MQ 調用服務提供者的服務

![image](https://user-images.githubusercontent.com/59738136/224939925-6447b04f-4c68-498f-8d6a-9fae829f1fc3.png)

### Eureka Server 集群
為避免註冊中心的單點故障導致服務無法註冊與發現，解決方式為啟用多個Eureka Server，在Eureka Server間互相註冊，這樣只要Eureka Client註冊在其中一個Eureka Server註冊，服務信息就會自動同步其他的Eureka Server。

範例:
有四個專案
eureka_server1
eureka_server2
eureka_server3
eureka_client
server1將自身服務信息註冊給server2、server3
server2將自身服務信息註冊給server1、server3
server3將自身服務信息註冊給server1、server2
註冊完後，將client服務信息註冊給server1，client服務的信息會自動同步給server2、server3

![image](https://user-images.githubusercontent.com/59738136/233244543-7d7d8a5e-1a0e-4276-a03b-c5bf46bb9e4c.png)


## 服務調用
//TODO
https://cloud.tencent.com/developer/article/2119911

## 服務熔斷

## 負載均衡
//TODO
![image](https://user-images.githubusercontent.com/59738136/234154447-4292df15-1b46-4481-ae60-dc2f0f43c624.png)

## 服務降級

## 服務消息隊列

## 配置中心管理

## 服務網關

## 服務監控

## 全鏈路追蹤

## 自動化構建部屬

## 服務定時任務調度操作
