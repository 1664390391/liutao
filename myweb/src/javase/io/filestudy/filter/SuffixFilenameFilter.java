package javase.io.filestudy.filter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * details:自定义后缀名文件过滤器
 * 实现文件名称过滤器的接口方法
 *
 * @author lt
 * @date 2018/10/24
 */
public class SuffixFilenameFilter implements FilenameFilter {

    private String suffix;

    public SuffixFilenameFilter(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 根据后缀名进行文件名称的过滤
     * @param dir
     * @param name
     * @return
     */
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }
}
