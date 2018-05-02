package com.uniubi.controller;

import com.uniubi.entity.*;
import com.uniubi.sdk.model.result.ContentResult;
import com.uniubi.sdk.util.JsonUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.uniubi.util.FileUtil.contentToTxt;

/**
 * Created by ZhouJianyi on 2018/1/25.
 */
@RestController
public class IController {
    //liking fit
    static String pass = "test1234";
    static String rooturl = "http://192.168.24.51:8090/";// 根接口
    static boolean isLikingFit = false;

    @RequestMapping(value = "/xcy/test")
    public ContentResult<Map<String, Object>> setIdentifyCallBack(String personId, String deviceKey, String type, String ip, long time, String path,String data) {
        Map<String, Object> map = new HashMap<>();
        map.put("personId", personId);
        map.put("deviceKey", deviceKey);
        map.put("type", type);
        map.put("ip", ip);
        map.put("time", time);
        map.put("path", path);
        map.put("data", data);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("识别回调：--------" + JsonUtil.toString(map));

        if (isLikingFit == true) {
            if (personId.equals("STRANGERBABY")) {
                showFailDialog("非会员", "请前往前台购买会员手环");
            } else {
                showSuccessDialog("至尊VIP卡", path);

            }


            try {
                Thread.sleep(5 * 100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            closeDialog();//关闭弹窗


            IdentifyControl(false);//关闭识別
        }
        ;

        contentToTxt(JsonUtil.toString(map), "C:\\Users\\uniubi\\Desktop\\callback\\setIdentifyCallBack.txt");
        return new ContentResult<Map<String, Object>>("SUS_000", map);
    }
//closeDialog

    public void closeDialog() {
        String result = null;
        System.out.println("closeDialog");

        result = HttpRequest.sendPost(rooturl + "closeAlterDialog?", "&pass=" + pass);
        System.out.println(result);
    }
    //showSuccessDialog

    public void showSuccessDialog(String name, String path) {
        String result = null;
        System.out.println("showSuccessDialog");

        result = HttpRequest.sendPost(rooturl + "identifySuccessDialog?", "name=" + name + "&path=" + path + "&pass=" + pass);
        System.out.println(result);
    }

    public void showFailDialog(String reason, String tip) {
        String result = null;

        System.out.println("showFailDialog");
        result = HttpRequest.sendPost(rooturl + "identifyFailDialog?", "reason=" + reason + "&tip=" + tip + "&pass=" + pass);
        System.out.println(result);
    }
    //IdentifyControl

    public void IdentifyControl(boolean startIdentify) {
        String result = null;
        System.out.println("IdentifyControl");

        result = HttpRequest.sendPost(rooturl + "identifyControl?", "startIdentify=" + startIdentify + "&pass=" + pass);
        System.out.println(result);
    }


    @RequestMapping(value = "/xcy/test1")
    public ContentResult<Map<String, Object>> setImgRegCallBack(String deviceKey, String personId, Long time, String imgPath, String faceId, String ip, String featureKey, String feature) {
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
        contentToTxt(JsonUtil.toString(map), "C:\\Users\\uniubi\\Desktop\\callback\\setImgRegCallBack.txt");
        return new ContentResult<Map<String, Object>>("SUS_001", map);
    }


    @RequestMapping(value = "/xcy/test2")
    public ContentResult<Map<String, Object>> setDeviceHeartBeat(String deviceKey, Long time, String ip, Integer personCount, Integer faceCount) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", deviceKey);
        map.put("time", time);
        map.put("ip", ip);
        map.put("personCount", personCount);
        map.put("faceCount", faceCount);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("设备心跳回调：--------" + JsonUtil.toString(map));
        contentToTxt(JsonUtil.toString(map), "C:\\Users\\uniubi\\Desktop\\callback\\setDeviceHeartBeat.txt");
        return new ContentResult<Map<String, Object>>("SUS_002", map);
    }

    @RequestMapping(value = "/xcy/test5")
    public ContentResult<Map<String, Object>> setImgRegCallBack2Json(@RequestBody ImgRegCallBack imgRegCallBack) {
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
        contentToTxt(JsonUtil.toString(map), "C:\\Users\\uniubi\\Desktop\\callback\\ImgRegCallBack2Json.txt");
        return new ContentResult<Map<String, Object>>("SUS_005", map);
    }

    @RequestMapping(value = "/xcy/test4")
    public ContentResult<Map<String, Object>> setDeviceHeartBeat2Json(@RequestBody DeviceHeartBeatCallBack callBack) {
        Map<String, Object> map = new HashMap<>();
        map.put("deviceKey", callBack.getDeviceKey());
        map.put("personCount", callBack.getPersonCount());
        map.put("time", callBack.getTime());
        map.put("faceCount", callBack.getFaceCount());
        map.put("ip", callBack.getIp());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println("设备心跳回调json：--------" + JsonUtil.toString(map));
        contentToTxt(JsonUtil.toString(map), "C:\\Users\\uniubi\\Desktop\\callback\\DeviceHeartBeat2Json.txt");
        return new ContentResult<Map<String, Object>>("SUS_004", map);
    }

    @RequestMapping(value = "/xcy/test3")
    public ContentResult<Map<String, Object>> setIdentifyCallBack2Json(@RequestBody IdentifyCallBack callBack) {
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
        contentToTxt(JsonUtil.toString(map), "C:\\Users\\uniubi\\Desktop\\callback\\IdentifyCallBack2Json.txt");
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
        //contentToTxt(JsonUtil.toString(map), "C:\\Users\\uniubi\\Desktop\\callback\\IdentifyCallBack2Json.txt");
        return new ContentResult<Map<String, Object>>("SUS_rzbd", map);
    }

    @RequestMapping(value = "/xcy/rzbd1")
    public ContentResult<Map<String, Object>> setrzbdCallBack(String deviceName, String name, String sex, String nation, String birthday, String idNum, String address, String idNo, String issuingOrgan, String usefulLife, String photoPath, String recordPhotoPath, String createTime, String compareResult) {
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
        //contentToTxt(JsonUtil.toString(map), "C:\\Users\\uniubi\\Desktop\\callback\\setImgRegCallBack.txt");
        return new ContentResult<Map<String, Object>>("SUS_001", map);
    }
}
