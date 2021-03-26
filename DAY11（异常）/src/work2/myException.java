package work2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author:LXY
 * @className:myException
 * @description:
 * @date:2021/3/2514:12
 * @version:0.1
 * @since:1.8
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class myException extends RuntimeException {
    private int lack;

}
