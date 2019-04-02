package com.zysl.common.validator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author: bxguo
 * @time: 2019/4/2 11:17
 */
@Slf4j
public class CommonValidator {

    private final static String[] DOC_TYPES = {"TXT", "DOC", "DOCX", "XLS", "PDF", "PPT"};
    private final static String[] IMG_TYPES = {"JPG", "JPEG", "PNG", "SVG", "BMP", "PSD", "GIF"};

    /**
     * 是否是文档格式
     * @param fileType
     * @return
     */
    public static boolean isDoc(String fileType) {
        log.info("===isDoc===fileType:{}",fileType);
        return customFileTypeCheck(Arrays.asList(DOC_TYPES), fileType);
    }

    /**
     * 是否是图片格式
     * @param fileType
     * @return
     */
    public static boolean isImage(String fileType) {
        log.info("===isDoc===fileType:{}",fileType);
        return customFileTypeCheck(Arrays.asList(IMG_TYPES), fileType);
    }

    /**
     * 按需判断文件格式
     *
     * @return
     */
    public static boolean customFileTypeCheck(List<String> regTypeList, String fileType) {
        if (CollectionUtils.isEmpty(regTypeList) || StringUtils.isBlank(fileType)) {
            return false;
        }
        return regTypeList.contains(fileType.toUpperCase());
    }
}
