import re

class Solution:
    def myAtoi1(self, str):
        """
        :type str: str
        :rtype: int
        """
        str = str.strip() # 去除前后空格
        
        pattern = r'\d+' # 从字符串中提取连续数字
        s1 = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
        s2 = ['+', '-']
        temp = ''
        if str == '':
            return 0
        elif str[0] not in s1:
            if str[0] in s2:
                if len(str) > 1: # 判断第二个字符是不是数字
                    if str[1] not in s1:
                        return 0
                temp = str[0] # 标记 +，-
            else:
                return 0
        
        
        if re.findall(pattern, str) == []:
            return 0
        else:
            digit_str = re.findall(pattern, str)[0]
            digit = int(temp + digit_str)
            INT_MAX = 2 ** 31 - 1
            INT_MIN = -2 ** 31
            if digit > INT_MAX:
                return INT_MAX
            elif digit < INT_MIN:
                return INT_MIN
            else:
                return digit

    def myAtoi2(self, str):
    	# Another solution
        """
        :type str: str
        :rtype: int
        """
        str = str.strip() # 去除前后空格
        pattern = r'(^[\+\-0]*\d+)\D*'
        str = re.findall(pattern, str)

        try:
        	result = int(''.join(str))
        	MAX_INT = 2 ** 31 - 1
            MIN_INT = -2 ** 31
            if result > MAX_INT:
            	return MAX_INT
            elif result < MIN_INT:
            	return MIN_INT
            else:
            	return result
        except:
        	return 0