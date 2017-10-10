class Solution(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n==0:
            return False
        else:
            while n>0:
                a = n & 3
                if a==0 or a==3:
                    return False
                else:
                    n = n>>1
            return True