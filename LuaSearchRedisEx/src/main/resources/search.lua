local searchKey = ARGV[1]:lower()
local results = {}

for _, key in ipairs(KEYS) do
    local orders = redis.call('HGETALL', key)

    for i = 1, #orders, 2 do
        local json = orders[i + 1]:lower()

        if string.find(json, searchKey) then
            table.insert(results, orders[i + 1])
        end
    end
end

return results


--
-- local searchKey = ARGV[1]:lower()
-- local results = {}
--
-- local orders = redis.call('HGETALL', KEYS[1])
--
-- for i = 1, #orders, 2 do
--     local json = orders[i + 1]:lower()
--
--     if string.find(json, searchKey) then
-- --         table.insert(results, orders[i])
--         table.insert(results, orders[i + 1])
--     end
-- end
--
-- return results
