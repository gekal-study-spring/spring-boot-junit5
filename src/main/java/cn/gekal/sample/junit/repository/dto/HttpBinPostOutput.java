package cn.gekal.sample.junit.repository.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;

public class HttpBinPostOutput {

    /** クエリーパラメータ */
    public Map<String, Object> args;

    /** リクエストデータ */
    public String data;

    /** フォームデータ */
    public Object files;

    /** フォームデータ */
    public Object form;

    /** リクエストヘッダ */
    public Object headers;

    /** リクエストボディーJSON */
    public Object json;

    /** オリジンIP */
    public String origin;

    /** リクエストURL */
    public String url;

    /**
     * args を取得します。
     *
     * @return args
     */
    public Map<String, Object> getArgs() {
        return args;
    }

    /**
     * args を設定します。
     *
     * @param args args
     */
    public void setArgs(Map<String, Object> args) {
        this.args = args;
    }

    /**
     * data を取得します。
     *
     * @return data
     */
    public String getData() {
        return data;
    }

    /**
     * data を設定します。
     *
     * @param data data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * files を取得します。
     *
     * @return files
     */
    public Object getFiles() {
        return files;
    }

    /**
     * files を設定します。
     *
     * @param files files
     */
    public void setFiles(Object files) {
        this.files = files;
    }

    /**
     * form を取得します。
     *
     * @return form
     */
    public Object getForm() {
        return form;
    }

    /**
     * form を設定します。
     *
     * @param form form
     */
    public void setForm(Object form) {
        this.form = form;
    }

    /**
     * headers を取得します。
     *
     * @return headers
     */
    public Object getHeaders() {
        return headers;
    }

    /**
     * headers を設定します。
     *
     * @param headers headers
     */
    public void setHeaders(Object headers) {
        this.headers = headers;
    }

    /**
     * json を取得します。
     *
     * @return json
     */
    public Object getJson() {
        return json;
    }

    /**
     * json を設定します。
     *
     * @param json json
     */
    public void setJson(Object json) {
        this.json = json;
    }

    /**
     * origin を取得します。
     *
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * origin を設定します。
     *
     * @param origin origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * url を取得します。
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * url を設定します。
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
