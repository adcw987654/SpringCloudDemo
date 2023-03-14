# SpringCloudDemo

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



## 服務調用

## 服務熔斷

## 負載均衡

## 服務降級

## 服務消息隊列

## 配置中心管理

## 服務網關

## 服務監控

## 全鏈路追蹤

## 自動化構建部屬

## 服務定時任務調度操作
