package com.uniubi.controller;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.uniubi.entity.*;
import com.uniubi.sdk.model.result.ContentResult;
import com.uniubi.sdk.util.JsonUtil;
import com.uniubi.util.GetDistanceTime;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ZhouJianyi on 2018/1/25.
 */
@RestController
public class IController {
    //liking fit
    static String pass = "test1234";
    static String rooturl = "http://192.168.24.2:8090/";
    static boolean isLikingFit = false;
    String voice="识别成功";
    @RequestMapping(value = "/xcy/test")
    public ContentResult<Map<String, Object>> getIdentifyCallBack(String personId, String deviceKey, String type, String ip, long time, String path,String data) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String d = sdf.format(time);
        Date date= null;
        try {
            date = sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String time1=sdf.format(new Date());
        String time2=sdf.format(date);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(new GetDistanceTime().getDistanceTime(time1,time2,"yyyy-MM-dd HH:mm:ss"));

        Map<String, Object> map = new HashMap<>();
        map.put("personId", personId);
        map.put("deviceKey", deviceKey);
        map.put("type", type);
        map.put("ip", ip);
        map.put("time", time);
        map.put("path", path);
        map.put("data", data);



        System.out.println("识别回调：--------" + JsonUtil.toString(map));

        if (isLikingFit == true) {
            if (personId.equals("STRANGERBABY")) {
                showFailDialog("非会员", "请前往前台购买会员手环",rooturl);

            } else {
                showSuccessDialog("至尊VIP卡", path,rooturl);

            }


            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            closeDialog(rooturl);//关闭弹窗

           // IdentifyControl(false,rooturl);//关闭识別

        }


        //contentToTxt(JsonUtil.toString(map), "C:\\Users\\uniubi\\Desktop\\callback\\getIdentifyCallBack.txt");
        return new ContentResult<Map<String, Object>>("SUS_000", map);
    }
//closeDialog

    public void closeDialog(String rooturl) {
        String result = null;
        System.out.println("closeDialog");

        result = HttpRequest.sendPost(rooturl + "closeAlterDialog?", "&pass=" + pass);
        System.out.println(result);
    }
    //showSuccessDialog

    public void showSuccessDialog(String name, String path,String rooturl) {
        String result = null;
        System.out.println("showSuccessDialog");

         voice="识别成功";
        result = HttpRequest.sendPost(rooturl + "identifySuccessDialog?", "name=" + name + "&path=" + path + "&pass=" + pass+ "&voice=" + voice);
        System.out.println(result);
    }

    public void showFailDialog(String reason, String tip,String rooturl) {
        String result = null;
        voice="识别失败";
        System.out.println("showFailDialog");
        result = HttpRequest.sendPost(rooturl + "identifyFailDialog?", "reason=" + reason + "&tip=" + tip + "&pass=" + pass+ "&voice=" + voice);
        System.out.println(result);
    }
    //IdentifyControl

    public void IdentifyControl(boolean startIdentify,String rooturl) {
        String result = null;
        System.out.println("IdentifyControl");

        result = HttpRequest.sendPost(rooturl + "identifyControl?", "startIdentify=" + startIdentify + "&pass=" + pass);
        System.out.println(result);
    }


    @RequestMapping(value = "/xcy/test1")
    public ContentResult<Map<String, Object>> getImgRegCallBack(String deviceKey, String personId, Long time, String imgPath, String faceId, String ip, String featureKey, String feature) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", deviceKey);
        map.put("personId", personId);
        map.put("time", time);
        map.put("imgPath", imgPath);
        map.put("faceId", faceId);
        map.put("ip", ip);
        map.put("featureKey", featureKey);
        map.put("feature", feature);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("照片注册回调：--------" + JsonUtil.toString(map));
        //contentToTxt(JsonUtil.toString(map), "C:\\Users\\uniubi\\Desktop\\callback\\getImgRegCallBack.txt");
        return new ContentResult<Map<String, Object>>("SUS_001", map);
    }



    @RequestMapping(value = "/xcy/test5")
    public ContentResult<Map<String, Object>> getImgRegCallBack2Json(@RequestBody ImgRegCallBack imgRegCallBack) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", imgRegCallBack.getDeviceKey());
        map.put("personId", imgRegCallBack.getPersonId());
        map.put("time", imgRegCallBack.getTime());
        map.put("imgPath", imgRegCallBack.getImgPath());
        map.put("faceId", imgRegCallBack.getFaceId());
        map.put("ip", imgRegCallBack.getIp());
        map.put("featureKey", imgRegCallBack.getFeatureKey());
        map.put("feature", imgRegCallBack.getFeature());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("照片注册回调json：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_005", map);
    }

    @RequestMapping(value = "/xcy/test4")
    public ContentResult<Map<String, Object>> getDeviceHeartBeat2Json(@RequestBody DeviceHeartBeatCallBack callBack) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", callBack.getDeviceKey());
        map.put("personCount", callBack.getPersonCount());
        map.put("time", callBack.getTime());
        map.put("faceCount", callBack.getFaceCount());
        map.put("ip", callBack.getIp());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("设备心跳回调json：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_004", map);
    }

    @RequestMapping(value = "/xcy/test3")
    public ContentResult<Map<String, Object>> getIdentifyCallBack2Json(@RequestBody IdentifyCallBack callBack) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", callBack.getDeviceKey());
        map.put("personId", callBack.getPersonId());
        map.put("path", callBack.getPath());
        map.put("time", callBack.getTime());
        map.put("type", callBack.getType());
        map.put("ip", callBack.getIp());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("识别回调json：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_003", map);
    }

    @RequestMapping(value = "/xcy/rzbd")
    public ContentResult<Map<String, Object>> rzbdCallBack2Json(@RequestBody RecognitionDto callBack) {
        Map<String, Object> map = new HashMap<>();
        map.put("Address", callBack.getAddress());
        map.put("Birthday", callBack.getBirthday());
        map.put("CompareResult", callBack.getCompareResult());
        map.put("CreateTime", callBack.getCreateTime());
        map.put("DeviceName", callBack.getDeviceName());
        map.put("IdNo", callBack.getIdNo());
        map.put("IdNum", callBack.getIdNum());
        map.put("IssuingOrgan", callBack.getIssuingOrgan());
        map.put("Name", callBack.getName());
        map.put("Nation", callBack.getNation());
        map.put("PhotoPath", callBack.getPhotoPath());
        map.put("RecordPhotoPath", callBack.getRecordPhotoPath());
        map.put("Sex", callBack.getSex());
        map.put("UsefulLife", callBack.getUsefulLife());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("识别回调json：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_rzbd", map);
    }



    @RequestMapping(value = "/xcy/rzbd1")
    public ContentResult<Map<String, Object>> getrzbdCallBack(String deviceName, String name, String sex, String nation, String birthday, String idNum, String address, String idNo, String issuingOrgan, String usefulLife, String photoPath, String recordPhotoPath, String createTime, String compareResult) {
        Map<String, Object> map = new HashMap<>();
        map.put("Address", address);
        map.put("Birthday", birthday);
        map.put("CompareResult", compareResult);
        map.put("CreateTime", createTime);
        map.put("DeviceName", deviceName);
        map.put("IdNo", idNo);
        map.put("IdNum", idNum);
        map.put("IssuingOrgan", issuingOrgan);
        map.put("Name", name);
        map.put("Nation", nation);
        map.put("PhotoPath", photoPath);
        map.put("RecordPhotoPath", recordPhotoPath);
        map.put("Sex", sex);
        map.put("UsefulLife", usefulLife);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("人证比对回调：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_001", map);
    }
    @RequestMapping(value = "/xcy/gs")
    public ContentResult<Map<String, Object>> getGsCallBack(String deviceKey, String personGuid, String showTime, String photoUrl, String type, String data, String recMode, String idCardInfo) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", deviceKey);
        map.put("personGuid", personGuid);
        map.put("showTime", showTime);
        map.put("photoUrl", photoUrl);
        map.put("type", type);
        map.put("data", data);
        map.put("recMode", recMode);
        map.put("idCardInfo", idCardInfo);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        int num=i.incrementAndGet();
        System.out.println("沃土回调：--------" + JsonUtil.toString(map));
        System.out.println("回调次数：--------" + num);
        return new ContentResult<Map<String, Object>>("SUS_001", map);    }

    @RequestMapping(value = "/xcy/gs1")
    public ContentResult<Map<String, Object>> GsCallBack2Json(@RequestBody RecognitionGS callBack) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", callBack.getDeviceKey());
        map.put("personGuid", callBack.getPersonGuid());
        map.put("showTime", callBack.getShowTime());
        map.put("photoUrl", callBack.getPhotoUrl());
        map.put("type", callBack.getType());
        map.put("data", callBack.getData());
        map.put("recMode", callBack.getRecMode());
        map.put("idCardInfo",callBack.getIdCardInfo());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("识别回调json：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_rzbd", map);
    }
//deviceKey、personGuid、faceGuid、appId、state、msg和time
    AtomicInteger i = new AtomicInteger(0);
    @RequestMapping(value = "/xcy/gspic")
    public ContentResult<Map<String, Object>> getPicRegisterCallBack(String deviceKey, String personGuid, String faceGuid, String appId, String state, String msg, String time) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", deviceKey);
        map.put("personGuid", personGuid);
        map.put("faceGuid", faceGuid);
        map.put("appId", appId);
        map.put("state", state);
        map.put("msg", msg);
        map.put("time", time);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));

        i.incrementAndGet();
        System.out.println("沃土照片下发状态回调：--------" + JsonUtil.toString(map));
        System.out.println("回调次数：--------" + i.get());

        return new ContentResult<Map<String, Object>>("SUS_001", map);
    }


    @RequestMapping(value = "/wo/test")
    public ContentResult<Map<String, Object>> getIdentifyCallBack(String personId, String deviceKey, String type, String ip, Long showTime, String photoUrl,String cardNo,String recMode,String idCardInfo,String aliveType) {
        Map<String, Object> map = new HashMap<>();
        map.put("personId", personId);
        map.put("deviceKey", deviceKey);
        map.put("type", type);
        map.put("ip", ip);
        map.put("showTime", showTime);
        map.put("photoUrl", photoUrl);
        map.put("cardNo", cardNo);
        map.put("recMode", recMode);
        map.put("aliveType", aliveType);
        map.put("idCardInfo", idCardInfo);



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("识别回调：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_000", map);
    }

    @RequestMapping(value = "/wo/test3")
    public ContentResult<Map<String, Object>> IdentifyCallBack2Json(@RequestBody wo_IdentifyCallBack callBack) {
        Map<String, Object> map = new HashMap<>();
        map.put("personId", callBack.getPersonId());
        map.put("deviceKey", callBack.getDeviceKey());
        map.put("type", callBack.getType());
        map.put("ip", callBack.getIp());
        map.put("showTime", callBack.getShowTime());
        map.put("photoUrl", callBack.getPhotoUrl());
        map.put("cardNo", callBack.getCardNo());
        map.put("recMode", callBack.getRecMode());
        map.put("aliveType", callBack.getAliveType());
        map.put("idCardInfo",callBack.getIdCardInfo());
        map.put("passTimeType", callBack.getPassTimeType());
        map.put("PermissionTimeType", callBack.getPermissionTimeType());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("识别回调json：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_003", map);
    }

    @RequestMapping(value = "/wo/test1")
    public ContentResult<Map<String, Object>> imgRegCallback(String personId, String deviceKey, String faceId, String ip, String createTime, String photoUrl,String feature) {
        Map<String, Object> map = new HashMap<>();
        map.put("personId", personId);
        map.put("deviceKey", deviceKey);
        map.put("createTime", createTime);
        map.put("ip", ip);
        map.put("photoUrl", photoUrl);
        map.put("faceId", faceId);
        map.put("feature", feature);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("照片注册回调：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_000", map);
    }

    @RequestMapping(value = "/wo/test4")
    public ContentResult<Map<String, Object>> imgRegCallback2Json(@RequestBody wo_imgRegCallback callBack) {
        Map<String, Object> map = new HashMap<>();
        map.put("personId", callBack.getPersonId());
        map.put("deviceKey", callBack.getDeviceKey());
        map.put("createTime", callBack.getCreateTime());
        map.put("ip", callBack.getIp());
        map.put("photoUrl", callBack.getPhotoUrl());
        map.put("faceId", callBack.getFaceId());
        map.put("feature", callBack.getFeature());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("照片注册回调json：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_003", map);
    }

    @RequestMapping(value = "/wo/test2")
    public ContentResult<Map<String, Object>> heartBeatCallback(String deviceKey, String createTime, String ip, String personCount, String faceCount, String version,String cpuUsageRate,String cpuTemperature,String freeDiskSpace,String memoryUsageRate) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", deviceKey);
        map.put("createTime", createTime);
        map.put("ip", ip);
        map.put("personCount", personCount);
        map.put("faceCount", faceCount);
        map.put("version", version);
        map.put("freeDiskSpace", freeDiskSpace);
        map.put("cpuUsageRate", cpuUsageRate);
        map.put("cpuTemperature", cpuTemperature);
        map.put("memoryUsageRate", memoryUsageRate);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("设备心跳回调：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_000", map);
    }

    @RequestMapping(value = "/wo/test5")
    public ContentResult<Map<String, Object>> heartBeatCallback2Json(@RequestBody wo_heartBeatCallback callBack) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", callBack.getDeviceKey());
        map.put("createTime", callBack.getCreateTime());
        map.put("ip", callBack.getIp());
        map.put("personCount", callBack.getPersonCount());
        map.put("faceCount", callBack.getFaceCount());
        map.put("version", callBack.getVersion());
        map.put("freeDiskSpace", callBack.getFreeDiskSpace());
        map.put("cpuUsageRate", callBack.getCpuUsageRate());
        map.put("cpuTemperature", callBack.getCpuTemperature());
        map.put("memoryUsageRate", callBack.getMemoryUsageRate());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("设备心跳回调：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_003", map);
    }



    @RequestMapping(value = "/xiaomai/test1")
    public ContentResult<Map<String, Object>> getTaskProcessingResultsjson(@RequestBody TaskProcessingResults taskProcessingResults) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", taskProcessingResults.getTaskNo());
        map.put("createTime", taskProcessingResults.getDeviceKey());
        map.put("ip", taskProcessingResults.getResult());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("设备执行任务结果：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_003", map);
    }

    @RequestMapping(value = "/xcy/test2")
    public CallbackResult<Map<String, Object>> getDeviceHeartBeat(String deviceKey, Long time, String ip, Integer personCount, Integer faceCount) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", deviceKey);
        map.put("time", time);
        map.put("ip", ip);
        map.put("personCount", personCount);
        map.put("faceCount", faceCount);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("设备心跳回调：--------" + JsonUtil.toString(map));
        System.out.println("设备心跳回调：--------"+new CallbackResult<Map<String, Object>>(true,"SUS_002",true, map).toString());


        return new CallbackResult<Map<String, Object>>(true,"SUS_002",true, map);
    }


    @RequestMapping(value = "/xiaomai/test2")
    public String getTaskInterface( ) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Map<String, Object> map = new HashMap<>();
        map.put("taskNo", "111");
        map.put("interfaceName", "person/create");
        map.put("result", true);
        map.put("person", "{\"name\": \"紫微\",\"idcardNum\": \"511323199204250562\",\"id\": \"\"}");


        System.out.println(sdf.format(new Date()));
        System.out.println("设备执行任务：--------" + JsonUtil.toString(map));

        return JsonUtil.toString(map);
    }
    @RequestMapping(value = "/xiaomai/test22")
    public ContentResult<Map<String, Object>> getTaskInterface( @RequestBody  BaseTaskInterface taskInterface) {
        System.out.println("设备开始获取任务：--------");
        System.out.println("获取到的任务：--------" + JsonUtil.toString(taskInterface));
        return new ContentResult<Map<String, Object>>("sucess");
    }
    @RequestMapping(value = "/xiaomai/test3")
    public ContentResult<Map<String, Object>> getTaskProcessingResults(String taskNo, String deviceKey, String result) {
        Map<String, Object> map = new HashMap<>();
        map.put("taskNo",taskNo );
        map.put("deviceKey", deviceKey);
        map.put("result", result);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("设备执行任务结果：--------" + JsonUtil.toString(map));

        return new ContentResult<Map<String, Object>>("SUS_003", map);
    }

    @RequestMapping(value = "/xhs/test")
    public ContentResult<Map<String, Object>> getException( @RequestBody  MException e ) {

        Map<String, Object> map = new HashMap<>();
        map.put("errorCode", e.getErrorCode());
        map.put("deviceSN", e.getDeviceSN());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("异常回调：--------" + JsonUtil.toString(map));
        return new ContentResult<Map<String, Object>>("sucess");
    }

}
