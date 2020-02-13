package cn.yt4j.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shichenyang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeVO {

    public Long id;

    public Long parentId;

    public List<TreeVO> children=new ArrayList<>();

    public void add(TreeVO node) {
        children.add(node);
    }

    public TreeVO(Long id, Long parentId) {
        this.id = id;
        this.parentId = parentId;
    }
}
